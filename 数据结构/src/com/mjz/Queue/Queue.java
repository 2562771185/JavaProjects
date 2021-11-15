package com.mjz.Queue;

/**
 * @PACKAGE_NAME: com.mjz.Queue
 * @author: JHZZ
 * @date: 2021/11/13 18:05
 * @PROJECT_NAME: JavaProjects
 */
public class Queue {
    private int maxSize;
    private int[] data;
    private int front = 0;
    private int rear = 0;

    public Queue() {
        maxSize = 10;
        data = new int[maxSize];
    }

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        data = new int[maxSize];
    }

    // 增
    public void addFirst(int value) {
        if (isFull()){
            System.out.println("容量不足！");
            return;
        }

    }

    public void addLast(int value) {
        if (isFull()) {
            System.out.println("Full!");
            return;
        }
        data[rear % maxSize] = value;
        rear++;
    }

    // 删
    public void removeFont() {
        if (isEmpty()){
            return;
        }
        //front++;

    }

    public void removeBack() {

    }
    // 改

    // 查
    public int getFront() {
        return -1;
    }

    public int getBack() {
        return -1;
    }
    //is empty ？
    private boolean isEmpty() {
        return rear == front;
    }
    private boolean isFull() {
       return rear == front-1;
    }
    public void print(){
        if (isEmpty()){
            System.out.println("Empty!");
            return;
        }
        System.out.print("[ ");
        for (int i = front; i < rear;++i){
            System.out.print(data[i]+" ");
        }
        System.out.println("]");
    }
}
