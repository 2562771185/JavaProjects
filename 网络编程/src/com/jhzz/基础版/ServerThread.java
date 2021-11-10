package com.jhzz.基础版;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @PACKAGE_NAME: com.jhzz
 * @author: JHZZ
 * @date: 2021/11/2 23:21
 * @PROJECT_NAME: JavaProjects
 */
//负责处理每个线程通信的线程类
public class ServerThread implements Runnable {
    //定义当前线程所处理的Socket
    Socket s = null;
    //该线程所处理的Socket对应的输入流
    BufferedReader br = null;

    public ServerThread(Socket s) throws IOException {
        this.s = s;
        //初始化该Socket对应输入流
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String content = null;
            //采用循环不断地从Socket中读取客户端发送过来地数据
            while((content = readFromClient()) != null){
                //遍历socketList中的每个Socket
                //将读到的内容向每个Socket发送一次
                for (Socket s : MyServer.socketList){
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
//                    System.out.println("输入需要发送的公告：");
//                    Scanner scan = new Scanner(System.in);
//                    String next = scan.next();
//                    ps.println("来自服务器的公告："+next);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //  读取客户端数据的方法
    private String readFromClient() {
        try {
            return br.readLine()+" <-- 服务器";
        } catch (IOException e) {
            //如果捕获到异常说明该Socket对应的客户端以关闭
            //删除该Socket
            System.out.println(s.toString()+"客户端异常！");
            MyServer.socketList.remove(s);
        }
        return null;
    }
}
