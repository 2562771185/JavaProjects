package 力扣;

import java.util.Arrays;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/9 15:25
 * @PROJECT_NAME: JavaProjects
 */
public class p88 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[] nums1 = new int[]{1, 2, 3,0,0,0};
        s.merge(nums1,3, new int[]{2, 5, 6},3);
        System.out.println(Arrays.toString(nums1));
    }
    static class Solution {

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if(m == 0 && n==0) return;
            int[] res = new int[m+n];
            int i=0,j=0;
            int count=0;
            while(i < m && j < n){
                if(nums1[i] <= nums2[j]){
                    res[count++] = nums1[i++];
                }
                else{
                    res[count++] = nums2[j++];
                }

            }
            while(i < m){
                res[count++] = nums1[i++];
            }
            while(j < n){
                res[count++] = nums2[j++];
            }
            for(int k=0;k< res.length;k++){
                nums1[k] = res[k];
            }
        }
    }
}
