package day8.UDP;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @PACKAGE_NAME: day8.UDP
 * @author: JHZZ
 * @date: 2021/10/29 13:41
 * @PROJECT_NAME: JavaProjects
 */
public class UploadServer {
    public static void main(String[] args) {
        System.out.println("服务器启动.....");

        Thread t= new Thread(()->{
            try {
                DatagramSocket socket = new DatagramSocket(789);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("g.txt"));

                byte[] buffer = new byte[1024];
                while (true) {
                    //创建数据包
                    DatagramPacket data = new DatagramPacket(buffer,1024);
                    //接受数据包
                    socket.receive(data);
                    int len = data.getLength();
                    System.out.println(new String(buffer,0,len));
                    //数据长度
                    System.out.println("len = " + len);
                    if (len == 3){
                        String flag = new String(buffer,0,len);
                        if ("bye".equals(flag)){
                            System.out.println("bye");
                            break;
                        }
                    }
                    //写入数据到文件输出流
                    out.write(buffer,0,len);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        });
        t.start();
    }
}
