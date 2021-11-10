package day4;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @PACKAGE_NAME: day4
 * @author: yiyangqianxi
 * @date: 2021/10/16 12:53
 * @PROJECT_NAME: JavaProjects
 */
public class SortObjectTest {
    public static void main(String[] args) {
        Person[] perArray = new Person[10];
        perArray[0] = new Person("呵呵", 12);
        perArray[1] = new Person("a刮骨", 45);
        perArray[2] = new Person("呜呜", 17);
        perArray[3] = new Person("多少啊", 14);
        perArray[4] = new Person("发噶", 60);
        perArray[5] = new Person("黑寡妇的", 11);
        perArray[6] = new Person("会发光的", 78);
        perArray[7] = new Person("b2俄大使", 45);
        perArray[8] = new Person("更多风格", 19);
        perArray[9] = new Person("企鹅", 20);

        Arrays.sort(perArray);
        for (Person p : perArray) {
            System.out.println("p = " + p);
        }
    }
}

class Person implements Comparable {
    String name;
    int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person t = (Person) o;
            if (this.age < t.age) {
                return -1;
            } else if (this.age == t.age) {
                return this.name.compareTo(t.name);
            }
            return 1;
        } else {
            throw new ClassCastException("类型不匹配!");
        }
    }
}
