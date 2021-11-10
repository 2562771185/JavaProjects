package com.jhzz.UDPTest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @PACKAGE_NAME: com.jhzz.UDPTest
 * @author: JHZZ
 * @date: 2021/11/7 20:04
 * @PROJECT_NAME: JavaProjects
 */
public class UdpClient {
    public static final int PORT = 30000;
    public static final String DEST_IP = "127.0.0.1";
    private static final int DATA_LEN = 4096;
    byte[] inBuff = new byte[DATA_LEN];
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    private DatagramPacket outData;
    public void init() throws Exception{
        //使用随机端口
        DatagramSocket socket = new DatagramSocket();
        //初始化发送的DatagramSocket
        outData = new DatagramPacket(
                new byte[0],0, InetAddress.getByName(DEST_IP), PORT);
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            byte[] bytes = scanner.nextLine().getBytes();
            outData.setData(bytes);
            socket.send(outData);
            socket.receive(inPacket);
            System.out.println(new String(inBuff,0,inPacket.getLength()));

        }
    }

    public static void main(String[] args) {
        try {
            new UdpClient().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
