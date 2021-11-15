package 力扣;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/10 16:31
 * @PROJECT_NAME: JavaProjects
 */
public class p121 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null) return 0;
            int minPrice = prices[0];
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < minPrice){
                    minPrice = prices[i];
                }else if (prices[i] - minPrice > maxProfit){
                    maxProfit = prices[i] - minPrice;
                }
            }
            return maxProfit;
        }
    }
    public static boolean judge (String str) {
        // write code here
        int low=0;
        int high=str.length() - 1;
        while(low < high){
            if(str.charAt(low) != str.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = judge("abaa");
        System.out.println(b);
    }
}
