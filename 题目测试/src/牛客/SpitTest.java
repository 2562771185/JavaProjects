package 牛客;

import java.util.*;

/**
 * @PACKAGE_NAME: 牛客
 * @author: JHZZ
 * @date: 2021/11/4 15:59
 * @PROJECT_NAME: JavaProjects
 */
public class SpitTest {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        String name = scanner.next();
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Amy");
        map.put(2, "Joe");
        map.put(3, "Tom");
        map.put(4, "Susan");

        //write your code here......
        for (Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.print(entry.getKey()+":"+ entry.getValue());
        }

    }
}
class ScoreException extends Exception {

    //write your code here......



}
