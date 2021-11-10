package day8.Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PACKAGE_NAME: day8.cn.sinjinsong.Chat
 * @author: JHZZ
 * @date: 2021/10/29 13:02
 * @PROJECT_NAME: JavaProjects
 */
public class ChatServer {
    public static void main(String[] args) {
        System.out.println("服务器运行.......");
        Thread t = new Thread(() -> {
            ServerSocket server = null;
            Socket socket = null;
            DataInputStream in = null;
            DataOutputStream out = null;
            BufferedReader keyboardIn = null;
            try {
                server = new ServerSocket(788);
                socket = server.accept();
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                keyboardIn = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
                    System.out.println("等待客户端的消息-------------");
                    //接受数据
                    String str = in.readUTF();
                    //打印数据
                    System.out.println("来自客户端的消息：" + str);
                    //发送数据
                    //读取从键盘输入的字符串
                    System.out.print("输入消息: ");
                    String keyboardStr = keyboardIn.readLine();
                    //结束标志
                    if ("bye".equals(keyboardStr)) {
                        break;
                    }
                    //发送消息
                    out.writeUTF(keyboardStr);
                    out.flush();
                    System.out.println("--------------------------");
                }
            } catch (IOException e) {
                System.out.println("服务器停止运行.......");
                e.printStackTrace();
            } finally {
                if (server != null) {
                    try {
                        server.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (keyboardIn != null) {
                    try {
                        keyboardIn.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        t.start();



    }

}
