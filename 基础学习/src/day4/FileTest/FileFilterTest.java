package day4.FileTest;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * @PACKAGE_NAME: day4.FileTest
 * @author: yiyangqianxi
 * @date: 2021/10/16 15:53
 * @PROJECT_NAME: JavaProjects
 */
public class FileFilterTest {
    public static void main(String[] args) {
        File dir = new File("/Users/yiyangqianxi/IdeaProjects/JavaProjects/src/day4");
        System.out.println("dir = " + dir);
        String[] files = dir.list();
        System.out.println("files = " + Arrays.toString(files));
        Filter filter = new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                return false;
            }
        };


    }
}
