package 力扣;

import java.util.HashMap;
import java.util.Map;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/9 15:04
 * @PROJECT_NAME: JavaProjects
 */
//两数之和
public class p1 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map;
            map = new HashMap<>();
            for(int i=0;i< nums.length; i++){
                if (map.containsKey(target - nums[i])){
                    return new int[]{i,map.get(target - nums[i])};
                }
                map.put(nums[i],i);
            }
            return null;
        }
    }
}
