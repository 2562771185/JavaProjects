package day4.collecion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @PACKAGE_NAME: day4.collecion
 * @author: yiyangqianxi
 * @date: 2021/10/16 14:18
 * @PROJECT_NAME: JavaProjects
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add(new String("b"));
        list.add("c");
        list.add(String.valueOf(1));
        list.add(String.valueOf(2));
        list.add(String.valueOf(1));
        list.add(String.valueOf(4));
        //遍历
        for(Object o : list) {
            System.out.println("o = " + o);
        }
        Iterator<String> it=list.iterator();
        while (it.hasNext()) {
            Object item=it.next();

            System.out.println("item = " + item);
        }

        System.out.println(list.size());
        System.out.println("list = " + list);
        int b = list.indexOf("b");
        System.out.println("b-index = " + b);
        int lastIndexOf = list.lastIndexOf(1);
        System.out.println("lastIndexOf = " + lastIndexOf);
        list.remove("a");
        System.out.println("list = " + list);
        System.out.println(list.contains(2));
        list.set(1,"A");
        System.out.println("list = " + list);
        list.clear();
        System.out.println("list = " + list);
    }
}
