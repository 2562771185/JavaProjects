package day7;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @PACKAGE_NAME: day7
 * @author: JHZZ
 * @date: 2021/10/26 21:44
 * @PROJECT_NAME: JavaProjects
 */
public class MyStack implements Serializable {
    @Override
    public String toString() {
        return "MyStack{" +
                "storage=" + Arrays.toString(storage) +
                ", capacity=" + capacity +
                ", count=" + count +
                '}';
    }

    static final long serialVersionUID = 42131231232L;
    //存放栈元素的数组
    private int[] storage;
    //栈的容量
    private int capacity;
    //栈中的元素
    private int count;
    //扩容倍数
    private static final int GROW_FACTOR = 2;

    //默认容量8
    public MyStack() {
        this.capacity = 8;
        this.storage = new int[capacity];
        this.count = 0;
    }

    public MyStack(int initcapacity) {
        if (initcapacity < 1) {
            throw new IllegalArgumentException("Capacity too small.");
        }
        this.capacity = initcapacity;
        this.storage = new int[capacity];
        this.count = 0;
    }

    //入栈
    public void push(int value) {
        if (count == capacity) {
            ensureCapacity();
        }
        storage[count++] = value;
    }

    //扩容
    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    //返回栈定元素并出栈
    public int pop() {
        count--;
        if (count == -1) {
            throw new IllegalArgumentException("Stack is empty.");
        }
        return storage[count];
    }

    //返回栈定元素
    public int peek() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty.");
        } else {
            return storage[count - 1];
        }
    }
    private boolean isEmpty() {
        return count == 0;
    }
    private int size() {
        return count;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println("stack.size() = " + stack.size());
        while (!stack.isEmpty()){
//            System.out.println("stack.peek() = " + stack.peek());
//            stack.pop();
            System.out.println("stack.pop() = " + stack.pop());
        }
        stack.pop();
        stack.push(1);
        System.out.println("stack = " + stack);
    }
}
