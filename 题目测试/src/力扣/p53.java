package 力扣;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/8 20:14
 * @PROJECT_NAME: JavaProjects
 */
public class p53 {
    public static void main(String[] args) {
        int i = Solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("i = " + i);
    }
    static class Solution {
        public static int maxSubArray(int[] nums) {
            if(nums.length == 1){
                return nums[0];
            }
//            OptionalInt max = Arrays.stream(nums).max();
//            int asInt = max.getAsInt();
//            System.out.println("asInt = " + asInt);

            int curr = 0;
            int oldSum = 0;
            int currSum = 0;
            int maxSum = nums[0];
            for(int i = 0;i < nums.length; i++){
                curr = nums[i];
                if(oldSum < 0){
                    currSum = curr;
                    maxSum = Math.max(oldSum,currSum);
                    oldSum = curr;
                }else{
                    currSum = oldSum + curr;
                    maxSum = Math.max(oldSum,currSum);
                    oldSum = currSum;
                }
            }
            return maxSum;
        }
    }
}
