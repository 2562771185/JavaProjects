package 力扣;

import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/13 17:36
 * @PROJECT_NAME: JavaProjects
 */
public class p383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || magazine == null)
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //
        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if(map.containsKey(ch) && map.get(ch) > 0){
                map.put(ch, map.get(ch) - 1);
            }else{
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

    }
}
