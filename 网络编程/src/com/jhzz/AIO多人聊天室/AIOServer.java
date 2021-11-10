package com.jhzz.AIO多人聊天室;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PACKAGE_NAME: com.jhzz.AIO多人聊天室
 * @author: JHZZ
 * @date: 2021/11/6 13:23
 * @PROJECT_NAME: JavaProjects
 */
public class AIOServer {
    static final int PORT = 25543;
    final static String UTF_8 = "utf-8";
    //存储多个客户端连接
    static List<AsynchronousSocketChannel> channelList =
            new ArrayList<>();
    public void startListen() {
        System.out.println("服务器启动......");
        try {
            //创建线程池
            ExecutorService executor = Executors.newFixedThreadPool(20);

            //以指定的线程池来创建一个AsynchronousChannelGroup
            AsynchronousChannelGroup channelGroup =
                    AsynchronousChannelGroup.withThreadPool(executor);
            System.out.println("创建线程池");
            //以指定的线程池来创建一个AsynchronousSocketServerChannel
            AsynchronousServerSocketChannel serverChannel =
                    AsynchronousServerSocketChannel.open(channelGroup).
                            //监听本机端口
                            bind(new InetSocketAddress(PORT));
            System.out.println("监听接口");
            //使用CompletionHandler接收来自客户端的连接请求
            serverChannel.accept(null,new AccpetHandler(serverChannel));
            System.out.println("服务器结束运行.....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        AIOServer server = new AIOServer();
            server.startListen();
    }
}
class AccpetHandler implements
        CompletionHandler<AsynchronousSocketChannel,Object> {
    private final AsynchronousServerSocketChannel serverChannel;
    public AccpetHandler(AsynchronousServerSocketChannel serverChannel) {
        this.serverChannel = serverChannel;
    }

    //定义一个ByteBuffer准备读取数据
    ByteBuffer buff = ByteBuffer.allocate(1024);

    //当实际IO操作完成时触发该方法
    @Override
    public void completed(AsynchronousSocketChannel sc, Object attachment) {
        System.out.println("记录新链接");
        //记录新链接进来的Channel
        AIOServer.channelList.add(sc);
        //准备接收客户端下一次连接
        serverChannel.accept(null,this);
        sc.read(buff, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buff.flip();
                //将buff中的内容转化为字符串
                String content =
                        StandardCharsets.UTF_8.decode(buff).toString();
                //遍历每个Channel，将接收到的信息写入每个Channel中
                for (AsynchronousSocketChannel c : AIOServer.channelList){
                    try {
                        c.write(ByteBuffer.wrap(content.getBytes(AIOServer.UTF_8))).get();
                    } catch (InterruptedException | ExecutionException | UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                //清楚缓冲区
                buff.clear();
                //读取下一次数据
                sc.read(buff,null,this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("读取数据失败："+exc);
                //从该Channel中读取数据失败，就将该Channel删除
                AIOServer.channelList.remove(sc);
            }
        });
    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        System.out.println("连接失败："+exc);
    }
}