package com.jhzz.cs;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @PACKAGE_NAME: com.jhzz.cs
 * @author: JHZZ
 * @date: 2021/11/3 13:14
 * @PROJECT_NAME: JavaProjects
 */
public class ClientThread extends Thread {

    //该客户端线程负责处理的输入流
    BufferedReader br = null;

    //使用一个网络输入来创建客户端线程
    public ClientThread(BufferedReader brServer) {
        this.br = brServer;
    }

    @Override
    public void run() {
        try {
            String line;
            //不断的从输入流中读取数据，并将这些数据打印输出
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
