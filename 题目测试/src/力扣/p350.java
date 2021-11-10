package 力扣;

import java.util.*;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/10 15:51
 * @PROJECT_NAME: JavaProjects
 */
public class p350 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            if(nums1 == null || nums2==null) return null;
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int len1=nums1.length;
            int len2=nums2.length;
            List<Integer> list = new ArrayList<>();
            int i=0,j=0;
            while(i<len1 && j<len2){
                if(nums1[i] == nums2[j]){
                    list.add(nums2[j]);
                    i++;
                    j++;
                }else if(nums1[i] < nums2[j]){
                    i++;
                }else{
                    j++;
                }
            }
            int[] res = new int[list.size()];
            for(int k=0;k <list.size();k++){
                res[k]=list.get(k);
            }
            return res;

        }
    }
}
