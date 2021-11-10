package 牛客;

import org.junit.Test;

import java.util.Scanner;
import java.lang.Math;
import java.util.regex.Pattern;

/**
 * @PACKAGE_NAME: 牛客
 * @author: JHZZ
 * @date: 2021/11/1 13:28
 * @PROJECT_NAME: JavaProjects
 */
public class k形图案 {
    public static void main(String[] args) {
        int n = 0;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        for (int i = n; i > 0; i--) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("*");
        for (int i = 0; i < n; i++) {
            for (int j = n+1; j >= n-i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    @Test
    public void test(){
        int s=0;
        System.out.println();
        Byte b=127;
        ++b;
        System.out.println("b = " + b);
    }
}
