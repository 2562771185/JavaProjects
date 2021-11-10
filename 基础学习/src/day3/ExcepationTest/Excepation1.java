package day3.ExcepationTest;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @PACKAGE_NAME: day3.ExcepationTest
 * @author: yiyangqianxi
 * @date: 2021/10/15 18:37
 * @PROJECT_NAME: JavaProjects
 */
public class Excepation1 {
    public static Date readDate() {
        FileInputStream readfile = null;
        InputStreamReader ir = null;
        BufferedReader in = null;
        String str = null;
        try {
            readfile = new FileInputStream("readme.txt");
            ir = new InputStreamReader(readfile);
            in = new BufferedReader(ir);
            //读取文件中的一行数据
             str = in.readLine();
            if (str == null) {
                return null;
            }
            System.out.println("str = " + str);
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            Date date = df.parse(str);
            return date;

        } catch (IOException e) {
            System.out.println("IO异常");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("转换异常");
            e.printStackTrace();
        }finally{
            System.out.println("读取完毕！"+str);
        }
        return null;
    }

    public static void main(String[] args) {
        Date date = readDate();
        System.out.println("读取到的日期 = " + date);
    }
}
class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}