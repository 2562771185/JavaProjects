package com.mjz;

import org.junit.Test;

/**
 * @PACKAGE_NAME: com.mjz
 * @author: JHZZ
 * @date: 2021/11/4 23:24
 * @PROJECT_NAME: JavaProjects
 */
public class Main {
    public static void main(String[] args) {

        MyLinkList mll = new MyLinkList();
        for (int i = 1; i <= 10 ; i++) {
            mll.addLast(i);
        }
        mll.print();
        mll.deleteFirst();
        mll.print();
        mll.addFirst(4);
        mll.print();
        mll.deleteLast();
        mll.deleteFirst();
        mll.print();
        System.out.println(test());
    }

    public static int test(){
        try {
            int n=10;
            int i = n / 0;
            return 10;
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }finally {
            System.out.println("finally");
            return 20;
        }
    }
}
