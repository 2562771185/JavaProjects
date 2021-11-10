package day7;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * @PACKAGE_NAME: day7
 * @author: JHZZ
 * @date: 2021/10/25 13:08
 * @PROJECT_NAME: JavaProjects
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        FileInputStream ifs = new FileInputStream("jdbc.properties");

        pros.load(ifs);

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");

        System.out.println("name = " + name);
        System.out.println("password = " + password);

    }
    @Test
    public void test1(){
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(2);
        numbers.add(4);
        numbers.add(0);

        Collections.sort(numbers);
        System.out.println("numbers = " + numbers);

//        List<Integer> list = new ArrayList<Integer>();
        List list = Arrays.asList(new Object[numbers.size()]);
        Collections.copy(list,numbers);
        System.out.println("list = " + list);
    }
    @Test
    public void test2(){
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> integers = Collections.synchronizedList(list);

        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<?> list4 = new ArrayList<>();
        list4 = list3;

    }
    @Test
    public void test3(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"qw");
        map.put(3,"wq");
        map.put(4,"e");
        map.put(5,"r");
        System.out.println("map = " + map);
        map.keySet().forEach(System.out::println);
        Collection<String> values = map.values();
        ArrayList<String> list = new ArrayList<>(values);
        //values.forEach(System.out::println);
        list.forEach(System.out::println);
    }
    @Test
    public void test4(){
        System.out.println((5>>2)>>>2);
        Object s = new String("123");
        System.out.println("s = " + s);


    }
}
