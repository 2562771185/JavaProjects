package com.jhzz.Channel;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PACKAGE_NAME: com.jhzz.Channel
 * @author: JHZZ
 * @date: 2021/11/6 11:51
 * @PROJECT_NAME: JavaProjects
 */
public class AsynChannelTest {
    public static void main(String[] args) {
    }

    @Test
    public void test01() throws Exception {
        //方式一
        //直接创建
        AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(30000));
        //方式二
        //使用AsynchronousChannelGroup创建
        // 1 创建一个线程池
        ExecutorService executorService = Executors.newFixedThreadPool(80);
        // 2 已指定的线程池来创建一个AsynchronousServerSocketGroup
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executorService);
        //3 已指定的线程池来创建一个AsynchronousServerSocketChannel
        AsynchronousServerSocketChannel channel1 = AsynchronousServerSocketChannel.open(channelGroup).bind(new InetSocketAddress(30000));

    }
}
