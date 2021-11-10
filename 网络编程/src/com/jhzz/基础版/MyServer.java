package com.jhzz.基础版;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @PACKAGE_NAME: com.jhzz
 * @author: JHZZ
 * @date: 2021/11/2 22:57
 * @PROJECT_NAME: JavaProjects
 */
public class MyServer {
    //定义保存所有的Socket 的 ArrayList
    public static ArrayList<Socket> socketList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);

        while(true){
            //此行代码会阻塞，将一直等待别人的链接
            Socket s = ss.accept();
            socketList.add(s);
            //每当客户端连接后启动一个ServerThread线程为该客户端服务
            new Thread(new ServerThread(s)).start();
            System.out.println("---------第"+socketList.size()+"连接---------");
        }
    }

}
