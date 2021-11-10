package com.jhzz.MulticastSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * @PACKAGE_NAME: com.jhzz.MulticastSocket
 * @author: JHZZ
 * @date: 2021/11/8 14:29
 * @PROJECT_NAME: JavaProjects
 */
//该类实现Runnable接口，作为线程的target
public class MuSocketTest implements Runnable {
    //使用常量作为本程序的多点广播IP地址
    private static final String BOOTSTRAP_IP = "230.0.0.1";
    //端口号
    public static final int PORT = 30000;
    //定义数据包大小
    private static final int DATA_LEN = 4096;
    //定义本程序的MulticastSocket实例
    private MulticastSocket socket = null;
    private InetAddress broadcastAddress = null;
    private Scanner scan = null;
    //接收数据的字节数组
    byte[] inBuff = new byte[DATA_LEN];
    //以指定字节数组创建准备接收数据的 数据包对象
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //定义一个发送的数据包对象
    private DatagramPacket outPacket = null;

    public void init() throws IOException {
        try {
            //创建键盘流
            scan = new Scanner(System.in);
            //创建用于发送、接收的MulticastSocket对象
            //该对象需要接收数据，所以需要指定端口
            socket = new MulticastSocket(PORT);
            broadcastAddress = InetAddress.getByName(BOOTSTRAP_IP);
            //将该Socket加入指定多点广播
            socket.joinGroup(broadcastAddress);
            //设置本MulticastSocket发送的数据会被回送到本身
            socket.setLoopbackMode(false);
            //初始化发送用的DatagramSocket，它包含一个长度为0的字节数组
            outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, PORT);
            //启动本实例的run（）方法
            new Thread(this).start();
            //不断的读取键盘输入
            while (scan.hasNext()) {
                //将键盘输入的字符串转化为字节
                byte[] bytes = scan.nextLine().getBytes();
                //设置发送的
                outPacket.setData(bytes);
                //send
                socket.send(outPacket);
            }
        } finally {
            socket.close();
        }
    }
    @Override
    public void run() {
        try {
            while(true){
                //读取Socket中的数据，放到inPacket封装的字节数组中
                socket.receive(inPacket);
                System.out.println("聊天内容："+new String(inBuff,0, inPacket.getLength()));
            }
        } catch (IOException e) {
          e.printStackTrace();
          if (socket != null) {
              try {
                  socket.leaveGroup(broadcastAddress);
              } catch (IOException ex) {
                  ex.printStackTrace();
              }
              socket.close();
              System.exit(1);
          }
        }
    }

    public static void main(String[] args) throws IOException {
        new MuSocketTest().init();
    }
}
