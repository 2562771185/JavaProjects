package com.jhzz.Channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;

/**
 * @PACKAGE_NAME: com.jhzz.Channel
 * @author: JHZZ
 * @date: 2021/11/6 12:15
 * @PROJECT_NAME: JavaProjects
 */
public class SimpAIOClient {
    static final int PORT = 30000;

    public static void main(String[] args) {
        try {
            //读取数据的ByteBuffer
            var buffer = ByteBuffer.allocate(1024);
            Charset utf = Charset.forName("UTF-8");
            //1创建AsynchronousSocketChannel对象
            var channelClient =
                    AsynchronousSocketChannel.open();
            //2连接远程服务器
            channelClient.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
            buffer.clear();
            //3从channelClient中读取数据
            channelClient.read(buffer).get();
            buffer.flip();
            //将内容转化为字符串
            String content = utf.decode(buffer).toString();
            System.out.println("服务器信息 = " + content);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
