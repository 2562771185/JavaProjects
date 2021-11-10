package day4.IOTest;

import java.io.*;

/**
 * @PACKAGE_NAME: day4.IOTest
 * @author: yiyangqianxi
 * @date: 2021/10/16 16:18
 * @PROJECT_NAME: JavaProjects
 */
public class CopyFileTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("b.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        long start =System.currentTimeMillis();
        byte[] bytes = new byte[1024];
        int len = bis.read(bytes);
        while (len != -1) {
            System.out.println("len = " + len);
            bos.write(bytes, 0, len);
            len = bis.read(bytes);
        }
        long end =System.currentTimeMillis();
        System.out.println("end = " + (end - start));
        fis.close();
        fos.close();

//        Reader read = new FileReader("a.txt");
//        char[] chars = new char[1024];
//        read.read(chars);
//        Writer write = new FileWriter("b.txt");
//        write.write(chars);
//        read.close();
//        write.close();
    }
}
