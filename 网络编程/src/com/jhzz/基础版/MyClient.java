package com.jhzz.基础版;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @PACKAGE_NAME: com.jhzz
 * @author: JHZZ
 * @date: 2021/11/2 23:39
 * @PROJECT_NAME: JavaProjects
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",30000);
        //客户端启动ClientThread线程不断地读取来自服务器地数据
        new Thread(new ClientThread(s)).start();
        //获取该Socket对应的输入流
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        //不断的读取键盘的输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((line = br.readLine()) != null){
            //将用户的键盘输入内容写入Socket对应的输入流
            ps.println(line);
        }
    }
}
