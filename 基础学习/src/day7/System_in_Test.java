package day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @PACKAGE_NAME: day7
 * @author: JHZZ
 * @date: 2021/10/27 15:35
 * @PROJECT_NAME: JavaProjects
 */
public class System_in_Test {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("请输入：");
            String s=bufferedReader.readLine();
            if ("e".equals(s) || "exit".equals(s)){
                break;
            }
            String upperCase = s.toUpperCase();
            System.out.println("upperCase = " + upperCase);

        }
        bufferedReader.close();
    }
}
