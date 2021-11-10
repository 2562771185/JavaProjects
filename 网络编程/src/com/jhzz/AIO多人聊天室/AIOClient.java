package com.jhzz.AIO多人聊天室;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @PACKAGE_NAME: com.jhzz.AIO多人聊天室
 * @author: JHZZ
 * @date: 2021/11/7 16:55
 * @PROJECT_NAME: JavaProjects
 */
public class AIOClient {
    final static String UTF_8 = "UTF-8";
    final static int PORT = 25543;
    //与服务器端的异步channel
    AsynchronousSocketChannel clientChannel;
    JFrame mainWin = new JFrame("多人聊天");
    JTextArea jta = new JTextArea(16, 48);
    JTextField jtf = new JTextField(40);
    JButton sendBn = new JButton("发送");

    public void init() {
        mainWin.setLayout(new BorderLayout());
        jta.setEditable(false);
        mainWin.add(new JScrollPane(jta), BorderLayout.CENTER);
        JPanel jp = new JPanel();
        jp.add(jtf);
        jp.add(sendBn);
        //发送消息的Action，Action是ActionListener的字接口
        Action sendAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = jtf.getText();
                if (content.trim().length() > 0) {
                    //将content内容写入Channel中
                    try {
                        clientChannel.write(
                                ByteBuffer.wrap(content.trim().getBytes(UTF_8))).get();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    } catch (ExecutionException ex) {
                        ex.printStackTrace();
                    } catch (UnsupportedEncodingException ex) {
                        ex.printStackTrace();
                    }
                }
                //清空输入框
                jtf.setText("");
            }
        };
        sendBn.addActionListener(sendAction);
        //将"Ctrl+Enter"键 和"send"关联
        jtf.getInputMap().put(KeyStroke.getKeyStroke('\n', InputEvent.CTRL_MASK), "send");
        //将"send"和sendAction关联
        jtf.getInputMap().put(KeyStroke.getKeyStroke("send"), sendAction);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.add(jp, BorderLayout.SOUTH);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public void connect() throws Exception {
        //定义一个ByteBuffer准备读取数据
        final ByteBuffer buff = ByteBuffer.allocate(1024);
        //创建一个线程池
        ExecutorService excutor = Executors.newFixedThreadPool(80);
        //以指定线程池来创建一个AsynchronousChannelGroup
        AsynchronousChannelGroup channelGroup =
                AsynchronousChannelGroup.withThreadPool(excutor);
        //以channelGroup作为组管理来 创建AsynchronousSocketChannel
        clientChannel = AsynchronousSocketChannel.open(channelGroup);
        //让AsynchronousSocketChannel连接到指定IP地址，端口
        clientChannel.connect(
                new InetSocketAddress("127.0.0.1", PORT)).get();
        jta.append("----与服务器连接成功-----\n");
        buff.clear();
        clientChannel.read(buff, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                buff.flip();
                //将buff中的内容转化为字符串
                String content = StandardCharsets.UTF_8.
                        decode(buff).toString();
                //显示从服务器读取的数据
                jta.append("某人说：" + content + "\n");
                buff.clear();
                clientChannel.read(buff, null, this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("读取数据失败："+exc);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        AIOClient client = new AIOClient();
        client.init();
        client.connect();
    }
}
