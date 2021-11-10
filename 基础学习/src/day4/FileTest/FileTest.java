package day4.FileTest;

import java.io.File;
import java.util.Date;

/**
 * @PACKAGE_NAME: day4.FileTest
 * @author: yiyangqianxi
 * @date: 2021/10/16 15:41
 * @PROJECT_NAME: JavaProjects
 */
public class FileTest {
    public static void main(String[] args) {
        File file = new File("a.txt");
        System.out.println(file.getName());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
        System.out.println("file.exists() = " + file.exists());
        System.out.println("file.canWrite() = " + file.canWrite());
        System.out.println("file.canRead() = " + file.canRead());
        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.isDirectory() = " + file.isDirectory());
        System.out.println("file.lastModified() = " + new Date(file.lastModified()));
        System.out.println("file.length() = " + file.length());
//        System.out.println("file.renameTo(new File(\"b.txt\")) = " + file.renameTo(new File("b.txt")));
//        System.out.println("file.list() = " + file.list());
        
        
        
    }
    
    
}
