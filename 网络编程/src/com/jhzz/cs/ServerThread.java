package com.jhzz.cs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @PACKAGE_NAME: com.jhzz.cs
 * @author: JHZZ
 * @date: 2021/11/3 12:16
 * @PROJECT_NAME: JavaProjects
 */
public class ServerThread extends Thread {
    private Socket socket;
    BufferedReader br = null;
    PrintStream ps = null;

    //定义一个构造器，用于接受一个Socket来创建ServerThread线程
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //获取对应Socket输入流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //获取该Socket输出流
            ps = new PrintStream(socket.getOutputStream());
            String line = null;

            while ((line = br.readLine()) != null) {
                //如果读到CrazyitProtocol.USER_ROUND开始，并以其结束
                //则可以确定读到用户登陆到用户名
                if (line.startsWith(CrazyitProtocol.USER_ROUND) &&
                        line.endsWith(CrazyitProtocol.USER_ROUND)) {
                    //得到真实消息
                    String userName = getRealMsg(line);
                    //如果用户名重复
                    if (Server.clients.containsKey(userName)) {
                        System.out.println("重复用户名！");
                        ps.println(CrazyitProtocol.NAME_REP);
                    } else {
                        System.out.println(userName + "成功注册！");
                        ps.println(CrazyitProtocol.LOGIN_SUCCESS);
                        Server.clients.put(userName, ps);
                    }
                }
                //如果读到的行以PRIVATE——ROUND开始，并结束
                //则可以确定是私聊信息，私聊信息只向特定输出流发送
                else if (line.startsWith(CrazyitProtocol.PRIVATE_ROUND) &&
                        line.endsWith(CrazyitProtocol.PRIVATE_ROUND)) {
                    //得到真实消息
                    String userAndMsg = getRealMsg(line);
                    //以SPLIT_SIGN分割字符串，前半是私聊用户，后半是聊天信息
                    String user = userAndMsg.split(CrazyitProtocol.SPLIT_SIGN)[0];
                    String msg = userAndMsg.split(CrazyitProtocol.SPLIT_SIGN)[1];
                    //获取私聊用户对应的输出流，发送私聊消息
                    Server.clients.get(user).println(Server.clients.getKeyByValue(ps) + " 悄悄地对你说：" + msg);
                }
                else if (line.equals("show")){
                    //发送到客户端 全部
//                    for (PrintStream clientPs : Server.clients.valueSet()) {
//                        clientPs.println("---------------------------------");
//                        clientPs.println("------------当前在线人数-------------" + Server.clients.size());
//                        for (String name : Server.clients.keySet()) {
//                            clientPs.println("ID ："+name);
//                        }
//                        clientPs.println("---------------------------------");
//                    }
                        ps.println("---------------------------------");
                        ps.println("------------当前在线人数-------------" + Server.clients.size());
                        for (String name : Server.clients.keySet()) {
                            ps.println("ID ："+name);
                        }
                        ps.println("---------------------------------");

                }
                //公聊要向每个Socket发送
                else {
                    //输出在服务器端
                    System.out.println("--------当前在线人数----------" + Server.clients.size());
                    for (String name : Server.clients.keySet()) {
                        System.out.println(name);
                    }
                    //得到真实消息
                    String msg = getRealMsg(line);
                    //遍历clients中的每个输出流
                    for (PrintStream clientPs : Server.clients.valueSet()) {
                        clientPs.println(Server.clients.getKeyByValue(ps) + " 说：" + msg);
                    }
                }

            }
        }
        //捕获到异常后，表明该Socket对应到客户端一出现问题
        //所以将其从Map中删除
        catch (IOException e) {
            Server.clients.removeByValue(ps);
            System.out.println(Server.clients.size());
            //关闭资源
            try {
                if (br != null) {
                    br.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //将读到到内容去掉前后到协议字符，恢复成真实数据
    private String getRealMsg(String line) {
        return line.substring(CrazyitProtocol.PROTOCOL_LEN,
                line.length() - CrazyitProtocol.PROTOCOL_LEN);
    }
}
