package day7;

import org.junit.Test;

import java.io.*;

/**
 * @PACKAGE_NAME: day7
 * @author: JHZZ
 * @date: 2021/10/27 17:09
 * @PROJECT_NAME: JavaProjects
 */
public class ObjectOut_In_StreamTest {
    /**
     * 序列化
     */
    @Test
    public void test1() {
        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream("obj.dat"));
            stream.writeObject(new String("哈哈哈哈韦涣知煞笔"));
            stream.flush();
            stream.writeObject(new MyStack());
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 反序列化
     */
    @Test
    public void test2() throws FileNotFoundException {
        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(new FileInputStream("obj.dat"));
            Object o = stream.readObject();
            String s = (String) o;
            System.out.println("s = " + s);
            Object o1 = stream.readObject();
            MyStack s1= (MyStack) o1;
            System.out.println("s1 = " + s1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
