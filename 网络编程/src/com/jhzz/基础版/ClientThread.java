package com.jhzz.基础版;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @PACKAGE_NAME: com.jhzz
 * @author: JHZZ
 * @date: 2021/11/2 23:41
 * @PROJECT_NAME: JavaProjects
 */
public class ClientThread implements Runnable {
    //该线程负责的处理的Socket
    private Socket s;
    //该线程所处理的Socket对应的输入流
    BufferedReader br = null;
    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        String content = null;
        //不断地读取Socket输入流中的内容，并将这些内容打印输入
        while(true){
            try {
                if (!((content = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("读取到到内容："+content);
        }

    }
}
