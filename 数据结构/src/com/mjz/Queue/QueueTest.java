package com.mjz.Queue;

/**
 * @PACKAGE_NAME: com.mjz.Queue
 * @author: JHZZ
 * @date: 2021/11/13 18:16
 * @PROJECT_NAME: JavaProjects
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        queue.addLast(4);
        queue.addLast(5);
        queue.print();
        queue.removeFont();
        queue.print();

    }
}
