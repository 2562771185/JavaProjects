package day4.collecion;

import java.util.HashMap;

/**
 * @PACKAGE_NAME: day4.collecion
 * @author: yiyangqianxi
 * @date: 2021/10/16 15:04
 * @PROJECT_NAME: JavaProjects
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"xiao");
        map.put(2,"呵呵");
        map.put(3,"刮骨");
        map.put(4,"嗷嗷");
        map.put(1,"么么哒");
        System.out.println("map = " + map);
        System.out.println("map = " + map.get(5));
        System.out.println("键集合-------");
        for (Object o : map.keySet()) {
            System.out.println("o = " + o + map.get(o));
        }
        System.out.println("值集合--------------");
        for (Object o : map.values()){
            System.out.println("o = " + o);
        }


    }
}
