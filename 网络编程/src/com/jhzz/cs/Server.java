package com.jhzz.cs;


import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PACKAGE_NAME: com.jhzz.cs
 * @author: JHZZ
 * @date: 2021/11/3 12:10
 * @PROJECT_NAME: JavaProjects
 */
public class Server {
    private static final int SERVER_PORT = 30000;
    //使用CrazyitMap对象来保存每个客户和对应的输入流之间的关系
    public static CrazyitMap<String, PrintStream> clients = new CrazyitMap<>();

    public void init() {
        try {
            //建立监听的ServerSocket
            ServerSocket ss = new ServerSocket(SERVER_PORT);
            //采用死循环不断接受来自客户端的请求
            while (true) {
                Socket socket = ss.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            System.out.println("服务器启动失败，请查看端口是否被占用" + SERVER_PORT);
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
        s.init();
    }
}
