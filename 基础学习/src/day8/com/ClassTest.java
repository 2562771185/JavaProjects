package day8.com;


import day8.com.Student;
import org.junit.Test;

import java.util.Random;

/**
 * @PACKAGE_NAME: day8
 * @author: JHZZ
 * @date: 2021/10/28 16:28
 * @PROJECT_NAME: JavaProjects
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Student> aClass = Student.class;
        System.out.println("aClass = " + aClass);
        Student s = new Student();
        Class<? extends Student> aClass1 = s.getClass();
        System.out.println("aClass1 = " + aClass1);
        Class<?> aClass2 = Class.forName("day8.com.Student");
        System.out.println("aClass2 = " + aClass2);
        System.out.println("(aClass ==aClass1) = " + (aClass == aClass1));

    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            int anInt = new Random().nextInt(3);
            String src = "";
            switch (anInt) {
                case 1:
                    src = "day8.com.Student";
                    break;
                case 2:
                    src = "java.util.Date";
                    break;
                case 0:
                    src="java.lang.Object";
            }
            Object instance = null;
            try {
                instance = getInstance(src);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("instance = " + instance);
        }
    }

    public Object getInstance(String classPath) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(classPath);
        try {
            return aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
