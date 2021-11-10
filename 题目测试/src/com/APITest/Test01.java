package com.APITest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * @PACKAGE_NAME: com.APITest
 * @author: JHZZ
 * @date: 2021/11/3 14:55
 * @PROJECT_NAME: JavaProjects
 */
public class Test01 {
    public static void main(String[] args) {
        String s="";
        System.out.println(s.getClass().getSimpleName());
    }
    @Test
    public void test01() throws Exception {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
//        list.add("aac");
        System.out.println("list = " + list);
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        int[] arr = {1,23,45,4,543,6};
        List<Integer> list1 = Arrays.asList(1, 3, 24, 2);
        Collections.reverse(list1);
        System.out.println("list1 = " + list1);

    }
}
