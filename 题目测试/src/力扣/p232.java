package 力扣;

import java.util.Stack;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/16 15:56
 * @PROJECT_NAME: JavaProjects
 * 请你仅使用两个栈实现先入先出队列。
 * 队列应当支持一般队列支持的所有操作
 * （push、pop、peek、empty）：
 */
public class p232 {
    class MyQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        //插入队尾
        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (empty()) return 0;
            while (!stack1.isEmpty()) {
                int pop = stack1.pop();
                stack2.push(pop);
            }
            int res = stack2.pop();
            while (!stack2.isEmpty()){
                int pop = stack2.pop();
                stack1.push(pop);
            }
            return res;
        }

        public int peek() {
            if (empty()) return 0;
            while (!stack1.isEmpty()) {
                int pop = stack1.pop();
                stack2.push(pop);
            }
            int res = stack2.peek();
            while (!stack2.isEmpty()){
                int pop = stack2.pop();
                stack1.push(pop);
            }
            return res;
        }

        public boolean empty() {
            return stack1.isEmpty();
        }
    }
}

