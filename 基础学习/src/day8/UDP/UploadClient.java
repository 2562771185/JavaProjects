package day8.UDP;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @PACKAGE_NAME: day8.UDP
 * @author: JHZZ
 * @date: 2021/10/29 13:41
 * @PROJECT_NAME: JavaProjects
 */
public class UploadClient {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动//////");

        DatagramSocket socket = new DatagramSocket();
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("a.txt"));
        InetAddress address = InetAddress.getByName("127.0.0.1");
        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        while (len != -1) {
            DatagramPacket data = new DatagramPacket(buffer,len,address,789);
            socket.send(data);
            len=in.read(buffer);
        }
        //发送结束标志
        DatagramPacket flag = new DatagramPacket("bye".getBytes(),3,address, 789);
        socket.send(flag);
        System.out.println("上传完成！");

        socket.close();
        in.close();
    }
}
