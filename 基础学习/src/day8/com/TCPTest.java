package day8.com;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PACKAGE_NAME: day8
 * @author: JHZZ
 * @date: 2021/10/27 21:56
 * @PROJECT_NAME: JavaProjects
 */
public class TCPTest {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket("127.0.0.1", 788);
        InputStream sis = socket.getInputStream();
        OutputStream sos = socket.getOutputStream();
        BufferedInputStream is = new BufferedInputStream(new FileInputStream("a.txt"));
        FileInputStream inputStream = new FileInputStream("a.txt");
        byte[] bytes = new byte[1024];
        int len;

        while ((len = is.read(bytes)) != -1){
            sos.write(bytes, 0, len);
        }
        socket.shutdownOutput();
        System.out.println("发送完毕！");

        byte[] data = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len = sis.read(data)) != -1){
            baos.write(data, 0, len);
        }
        System.out.println(baos);

        socket.close();
        inputStream.close();
        sis.close();
        sos.close();
        baos.close();
        is.close();
    }
    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(788);
        Socket socket = ss.accept();
        InputStream sis = socket.getInputStream();
        OutputStream sos = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("aa.txt"));
        FileOutputStream outputStream = new FileOutputStream("aa.txt");
        byte[] data = new byte[1024];
        int len;
        while ((len = sis.read(data)) != -1){
            outputStream.write(data, 0, len);
        }
        System.out.println("收到"+socket.getInetAddress().getHostAddress());

        //发送
        sos.write("服务器：接受成功！".getBytes());

        ss.close();
        socket.close();
        sis.close();
        sos.close();
        outputStream.close();


    }
}
