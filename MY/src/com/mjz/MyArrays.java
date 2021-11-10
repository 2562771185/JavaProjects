package com.mjz;

/**
 * @PACKAGE_NAME: com.mjz
 * @author: JHZZ
 * @date: 2021/11/4 23:13
 * @PROJECT_NAME: JavaProjects
 */
public class MyArrays {
    private int capacity = 10;
    private int length = 0;
    private int[] arr;

    public MyArrays() {
        arr = new int[10];
    }

    public MyArrays(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public MyArrays(int[] arr) {
        this.arr = arr;
    }

    public int get(int index){
        return arr[index];
    }
    public int getLength() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

    public void insert(int val) {
        if (capacity == length){
            //扩容操作
            System.out.println("扩容操作");
            int[] newarr=new int[arr.length*2];
            newarr  = arr.clone();
            arr=newarr;

        }else{
            arr[length++] = val;
        }
    }
    public int remove(int index) {
        if (index >= capacity && index < 0){
            return -1;
        }else if(index >= length){
            return -1;
        }
        for (int i = index; i <length ; i++) {
            arr[i] = arr[i+1];
        }

        length--;
        return arr[index];
    }
    public void print(){
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }
}
