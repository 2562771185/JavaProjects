package day8.com;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PACKAGE_NAME: day8
 * @author: JHZZ
 * @date: 2021/10/27 21:14
 * @PROJECT_NAME: JavaProjects
 */
public class SocketTest {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        BufferedInputStream stream = null;
        try {
            socket = new Socket("127.0.0.1", 789);
            outputStream = socket.getOutputStream();
            inputStream = new FileInputStream("1.jpeg");
            stream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = stream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
            socket.shutdownOutput();
            System.out.println("发送完毕！");
            InputStream is = socket.getInputStream();
            stream = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = stream.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            System.out.println("baos = " + baos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null){
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(789);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream outputStream = new FileOutputStream("3.jpeg");
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        byte[] bytes = new byte[1024];
        int len;
//        while ((len = inputStream.read(bytes)) != -1) {
//            baos.write(bytes, 0, len);
//        }
//        System.out.println("baos.toString() = " + baos.toString());
        while ((len = inputStream.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        System.out.println("来自于：" + accept.getInetAddress().getHostAddress() + "的消息");

        OutputStream os = accept.getOutputStream();
        bos= new BufferedOutputStream(os);
        bos.write("服务端：接受成功！".getBytes());


        os.close();
        serverSocket.close();
        accept.close();
        inputStream.close();
        baos.close();
        bos.close();
    }
}
