package com.jhzz.UDPTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @PACKAGE_NAME: com.jhzz.UDPTest
 * @author: JHZZ
 * @date: 2021/11/7 19:51
 * @PROJECT_NAME: JavaProjects
 */
public class UdpServer {
    public static final int PORT = 30000;
    //定义每个数据报的最大大小为 4kb
    private static final int DATA_LEN = 4096;
    //接收网络的数组
    byte[] inBuff = new byte[DATA_LEN];
    //指定准备接收数据的DatagramPacket对象
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    private DatagramPacket outData;
    //定义一个字符串数组，服务器发送该数组的元素、
    String[] books = new String[]{
            "哈哈哈", "呵呵IEhi", "挂嘎嘎", "我问问"
    };

    public void init() throws Exception {

        DatagramSocket socket = new DatagramSocket(PORT);
        for (int i = 0; i < 1000; i++) {
            //读取Socket里面的数据，放入inPacket封装的数组中
            socket.receive(inPacket);
            //判断inPacket。getData() 和inBuff是否为统一数组
            System.out.println(inBuff == inPacket.getData());
            //转化为字符串输出
            System.out.println(new String
                    (inBuff, 0, inPacket.getLength()));
            //从字符串数组中取出一个元素作为发送数据
            byte[] sendData = books[i % 4].getBytes();
            //以指定的字节数组作为发送数据，以刚刚接收到的DatagramPacket
            //源SocketAddress作为发送目标
            outData = new DatagramPacket(
                    sendData,sendData.length,inPacket.getSocketAddress());
            //发送
            socket.send(outData);
        }
    }

    public static void main(String[] args) throws Exception {
        new UdpServer().init();
    }
}
