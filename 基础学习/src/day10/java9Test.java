package day10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @PACKAGE_NAME: day10
 * @author: JHZZ
 * @date: 2021/11/9 13:33
 * @PROJECT_NAME: JavaProjects
 */
public class java9Test {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("a.txt");
        FileOutputStream outputStream = new FileOutputStream("a22.txt");
        inputStream.transferTo(outputStream);
    }
}
