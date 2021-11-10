package day4.collecion;

import java.util.ArrayList;
import java.util.List;

/**
 * @PACKAGE_NAME: day4.collecion
 * @author: yiyangqianxi
 * @date: 2021/10/16 15:25
 * @PROJECT_NAME: JavaProjects
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.queue("1");
        queue.queue("2");
        queue.queue("3");
        queue.queue("4");
        queue.queue("5");
        queue.queue("6");
        //queue.queue(7);
        System.out.println("queue = " + queue);
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println("queue.dequeue() = " + queue.dequeue());

    }
}

class Queue<T>{
    private List<T> items;

    public Queue() {
        this.items = new ArrayList<T>();
    }

    Queue(List<T> items) {
        this.items = items;
    }

    public void queue(T item) {
        this.items.add(item);
    }
    public T dequeue() {
        if (items.isEmpty()) {
            return null;
        }else{
            return this.items.remove(0);
        }
    }

    @Override
    public String toString() {
        return "Queue{" +
                "items=" + items +
                '}';
    }
}
