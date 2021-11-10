package day8.Chat;

import java.io.*;
import java.net.Socket;

/**
 * @PACKAGE_NAME: day8.cn.sinjinsong.Chat
 * @author: JHZZ
 * @date: 2021/10/29 13:02
 * @PROJECT_NAME: JavaProjects
 */
public class ChatClient {

    public static void main(String[] args) {
        System.out.println("客户端运行.........");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Socket socket = null;
                DataInputStream in = null;
                DataOutputStream out = null;
                BufferedReader keyboardIn = null;
                try {
                    socket = new Socket("127.0.0.1", 788);
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());
                    keyboardIn = new BufferedReader(new InputStreamReader(System.in));

                    while(true){
                        System.out.println("----------------------------");
                        System.out.println("输入消息：");
                        //发送数据
                        //读取从键盘输入的字符串
                        String keyboardStr = keyboardIn.readLine();
                        //结束标志
                        if ("bye".equals(keyboardStr)) {
                            break;
                        }
                        //发送消息
                        out.writeUTF(keyboardStr);
                        out.flush();
                        //接受数据
                        String str = in.readUTF();
                        //打印数据
                        System.out.println("来自服务器的消息：" + str);
                        System.out.println("----------------------------");
                    }
                } catch (IOException e) {
                    System.out.println("服务器未运行........");
                } finally {
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
            }
        });

        t.start();
    }
}
