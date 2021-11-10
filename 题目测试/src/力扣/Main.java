package 力扣;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/8 19:53
 * @PROJECT_NAME: JavaProjects
 */
public class Main {
    public static void main(String[] args) {
        Class<String> clzz = String.class;
        Constructor<?>[] constructors = clzz.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(System.out::println);

    }
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Map<Integer,Boolean> map = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(nums[i])){
                    return false;
                }
                map.put(nums[i],true);
            }
            return true;
        }
    }
}
