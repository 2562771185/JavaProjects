package 力扣;

import java.util.Stack;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/16 15:17
 * @PROJECT_NAME: JavaProjects
 */
public class p20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s.length() == 0)
            return true;
        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            if (ch == ']' || ch == ')' || ch == '}'){
                if (stack.isEmpty() || !isMatch(stack.peek(),ch)){
                    return false;
                }else {
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }


        return stack.isEmpty();
    }
   public static boolean isMatch(char left, char right) {

        switch (right){
            case ']':return left == '[';
            case '}':return left == '{';
            case ')':return left == '(';
        }
        return false;
    }

    public static void main(String[] args) {
        boolean valid = isValid("(){{}{}}[]");
        System.out.println(valid);

    }
}
