package day11;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @PACKAGE_NAME: day11
 * @author: JHZZ
 * @date: 2021/11/9 13:36
 * @PROJECT_NAME: JavaProjects
 */
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.forEach(System.out::println);
        list.stream().dropWhile(x -> x < 5).forEach(System.out::print);
    }
    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("haha");
        list.add("gg");
        list.add("kk");
        Optional<ArrayList<String>> optional = Optional.ofNullable(list);
        Stream<ArrayList<String>> stream = optional.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out::println);

    }
    @Test
    public void test1(){
        System.out.println("     ".isBlank());
        System.out.println("----"+"    \n  ads".strip()+"--------");
        System.out.println();
        float f = 45.0f;
        Double d= Double.valueOf(45);
    }

}
