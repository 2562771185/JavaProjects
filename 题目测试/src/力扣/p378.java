package 力扣;

import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/13 17:15
 * @PROJECT_NAME: JavaProjects
 */
public class p378 {
    public int firstUniqChar(String s) {
        if (s == null) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.get(ch) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
