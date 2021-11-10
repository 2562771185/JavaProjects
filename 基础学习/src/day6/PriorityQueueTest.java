package day6;

import org.junit.Test;

import java.util.*;

/**
 * @PACKAGE_NAME: day6
 * @author: JHZZ
 * @date: 2021/10/21 16:37
 * @PROJECT_NAME: JavaProjects
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.offer(6);
        queue.offer(-2);
        queue.offer(9);
        queue.offer(4);
        System.out.println("queue = " + queue);
        System.out.println("queue.poll() = " + queue.poll());
    }

    @Test
    public void test1() {
        Hashtable<A, String> map = new Hashtable<A, String>();
        map.put(new A(123), "123");
        map.put(new A(456), "456");
        Iterator it = map.keySet().iterator();
        A first = (A) it.next();
        System.out.println("first = " + first + "   first.count = " + first.count);
        System.out.println("map = " + map);
        first.count = 123;
        System.out.println("map = " + map);
        map.remove(new A(123));
        System.out.println("map = " + map);
        System.out.println(map.get(new A(123)));
        System.out.println(map.get(new A(456)));
    }

    @Test
    public void test2() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        map.put("语文", 110);
        map.put("数学", 130);
        map.put("英语", 10);
        map.put("体育", 60);
        for (Object o : map.keySet()) {
            System.out.println(o + "  = " + map.get(o));
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(2);
        arr.add(-2);
        arr.add(23);
        arr.add(12);
        arr.add(5);
        System.out.println("arr = " + arr);
        System.out.println("排序： ");
        Collections.sort(arr);
        System.out.println("arr = " + arr);
        System.out.println("翻转：");
        Collections.reverse(arr);
        System.out.println("arr = " + arr);
        System.out.println("随机排序：");
        Collections.shuffle(arr);
        System.out.println("arr = " + arr);
    }

    @Test
    public void test3() {
        LinkedList<A> list = new LinkedList<>();
        list.add(new A(32));
        list.add(new A(123));
        list.add(new A(-123));
        list.add(new A(38));
        for (Object o : list) {
            System.out.println("o = " + o);
        }
        Collections.sort(list);
        System.out.println("list = " + list);
    }

    @Test
    public void test4() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(4);
        List res = fun(list);
        System.out.println("res = " + res);
    }

    @Test
    public void test5() {
        TreeMap<Person, Integer> map = new TreeMap<Person, Integer>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        Person p1 = new Person("mm", 12);
        Person p2 = new Person("aa", 23);
        Person p3 = new Person("cc", 34);
        Person p4 = new Person("dd", 13);
        Person p5 = new Person("jj", 13);

        map.put(p1, 66);
        map.put(p2, 123);
        map.put(p3, 99);
        map.put(p4, 76);
        map.put(p5, 45);

        for (Object o : map.keySet()) {
            System.out.println("key:"+o+" values:"+map.get(o));
        }


    }

    private List fun(List<Integer> list) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.addAll(list);

        return new ArrayList(set);
    }
}

class Person  {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof Person) {
//            Person t = (Person) o;
//            return Integer.compare(t.age,this.age);
//        }
//        throw new RuntimeException("类型不一致！");
//    }
}

class A implements Comparable {
    public int count;

    public A(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return count == a.count;
    }

    @Override
    public String toString() {
        return "A{" +
                "count=" + count +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof A) {
            A t = (A) o;
            return Integer.compare(this.count, ((A) o).count);
        } else {
            throw new RuntimeException("数据不一致！");
        }
    }
}