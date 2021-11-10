package com.mjz;

/**
 * @PACKAGE_NAME: com.mjz
 * @author: JHZZ
 * @date: 2021/11/5 13:01
 * @PROJECT_NAME: JavaProjects
 */
public class MyLinkList {
    /**
     * 内部类 Node
     */
    private class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;//第一个元素
    private Node last;//最后一个元素

    public MyLinkList() {
    }

    //头插法
    public void addFirst(int val) {
        Node node = new Node(val);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    //尾插法
    public void addLast(int val) {
        var node = new Node(val);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            node.next = null;
            last = node;
        }
    }

    //删除头部
    public void deleteFirst() {
        if (isEmpty())
        {
            System.out.println("Empty!");
            return;
        }
        if (first == last){
            first = last = null;
            return;
        }
        Node node = first.next;
        first.next = null;
        first = node;
    }

    //删除尾部
    public void deleteLast() {
        if (isEmpty())
        {
            System.out.println("Empty!");
            return;
        }
        if (first == last){
            first = last = null;
            return;
        }
        Node prevNode = getPrevNode(last);
        last = prevNode;
        last.next = null;
    }

    //查询存在
    public boolean contains(int val) {
        if (isEmpty()) return false;
        return indexOf(val) != -1;
    }

    //indexOf 返回位置
    public int indexOf(int value) {
        if (isEmpty()) return -1;
        Node head = first;
        int count = 0;
        while (head != null) {
            if (head.value == value) {
                return count;
            }
            head = head.next;
            count++;
        }
        return -1;
    }

    public void print() {
        if (isEmpty())
        {
            System.out.println("Empty!");
            return;
        }
        Node node = first;
        System.out.print("[ ");
        while (node != null) {
            if (node.next == null) {
                System.out.print(node.value + " -> null");
                break;
            }
            System.out.print(node.value + " -> ");
            node = node.next;
        }
        System.out.print(" ]");
        System.out.println();
    }

    //判空
    private boolean isEmpty() {
        return first == null;
    }
    //获取前一个节点
    private Node getPrevNode(Node node) {
        Node current = first;
        while (current != null){
            if (current.next == node)
                return current;
            current = current.next;
        }
        return null;
    }
}
