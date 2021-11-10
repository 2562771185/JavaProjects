package day4;

/**
 * @PACKAGE_NAME: day4
 * @author: yiyangqianxi
 * @date: 2021/10/16 17:41
 * @PROJECT_NAME: JavaProjects
 */
public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        Thread producer = new Thread(() -> {
            char c;
            for (int i = 0; i < 10; i++) {
                c = (char) (Math.random() * 26 + 'A');
                try {
                    stack.push(c);
                    System.out.println("生产 = " + c);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(() -> {
            char c;
            for (int i = 0; i < 10; i++) {
                try {
                    c = stack.pop();
                    System.out.println("消费 = " + c);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
    }
}

class Stack {
    private int pointer;
    private char[] data = new char[5];

    public synchronized void push(char c) throws InterruptedException {
        while (pointer == data.length) {
            System.out.println("等待数据出栈......");
            this.wait();
        }
        notify();
        data[pointer++] = c;
    }

    public synchronized char pop() throws InterruptedException {
        while (pointer == 0) {
            System.out.println("栈空，等待进栈.....");
            wait();
        }
        notify();
        pointer--;
        return data[pointer];
    }
}