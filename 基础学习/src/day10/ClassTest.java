package day10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @PACKAGE_NAME: day10
 * @author: JHZZ
 * @date: 2021/10/30 17:29
 * @PROJECT_NAME: JavaProjects
 */
public class ClassTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class c = String.class;

        for (Method method : c.getDeclaredMethods()) {
            System.out.println("method = " + method);
        }

        for (Field field : c.getDeclaredFields()) {
            System.out.println("field = " + field);
        }
        try {
            Field field = c.getDeclaredField("value");
            System.out.println("--------field = " + field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
