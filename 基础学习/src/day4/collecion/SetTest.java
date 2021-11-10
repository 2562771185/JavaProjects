package day4.collecion;

import java.util.*;

/**
 * @PACKAGE_NAME: day4.collecion
 * @author: yiyangqianxi
 * @date: 2021/10/16 14:39
 * @PROJECT_NAME: JavaProjects
 */
public class SetTest {
    public static void main(String[] args) {
        
        Set hashSet = new HashSet<>();
        String b="b";
        hashSet.add(1);
        hashSet.add(b);
        hashSet.add(new Person_m("tom",19));
        hashSet.add(new Person_m("tom",19));
        hashSet.add(new Person_m("tom",20));
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(2);
        hashSet.add(1);
        hashSet.add(3);
        System.out.println("hashSet = " + hashSet);
        for(Object o : hashSet){
            System.out.println("o = " + o);
        }
        Iterator<Integer> it=hashSet.iterator();
        //System.out.println("it = " + it.next());
        while(it.hasNext()){
            Object item=it.next();
            System.out.println("item = " + item);
        }

    }
}
class Person_m{
    String name;
    int age;

    public Person_m(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person_m person_m = (Person_m) o;
        return age == person_m.age && Objects.equals(name, person_m.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person_m{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}