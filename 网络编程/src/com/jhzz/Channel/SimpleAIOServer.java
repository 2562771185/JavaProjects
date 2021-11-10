package com.jhzz.Channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @PACKAGE_NAME: com.jhzz.Channel
 * @author: JHZZ
 * @date: 2021/11/6 12:04
 * @PROJECT_NAME: JavaProjects
 */
public class SimpleAIOServer {
    static final int PORT = 30000;

    public static void main(String[] args) {
        try {
            //1创建AsynchronousServerSocketChannel对象
            AsynchronousServerSocketChannel socketChannel;
            //2指定在指定地址、端口监听
            socketChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(PORT));
            while (true){
                //3采用循环接受客户端的请求连接
                Future<AsynchronousSocketChannel> future =
                        socketChannel.accept();
                //获取连接完成后返回的AsynchronousSocketChannel
                AsynchronousSocketChannel channel = future.get();
                //执行输出
                channel.write(ByteBuffer.wrap("花岗岩".getBytes(StandardCharsets.UTF_8))).get();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
