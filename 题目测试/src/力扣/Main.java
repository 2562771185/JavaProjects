package 力扣;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/8 19:53
 * @PROJECT_NAME: JavaProjects
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("输入：");
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
        int[][] arr = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j <= i; j++){
                if (i==j || j==1){
                    arr[i][j] =1;
                }else{
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++){
                if (arr[i][j] != 0)
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    @Test
    public void test(){
        //稀疏数组
        int[][] srcArr = new int[11][11];
        srcArr[5][6] = 1;
        srcArr[3][4] = 2;
        srcArr[2][6] = 2;
        srcArr[6][4] = 2;
        srcArr[8][4] = 2;
        srcArr[9][4] = 2;
        System.out.println("-----------原始数组------------");
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (srcArr[i][j] != 0) sum++;
                System.out.print(srcArr[i][j]+"  ");
            }
            System.out.println();
        }
        //稀疏数组
        int count = 1;
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (srcArr[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = srcArr[i][j];
                    count++;
                }
            }
        }
        System.out.println("稀疏数组: row   clonms values");
        for (int i = 0; i < sparseArr.length ; i++) {
            for (int j = 0; j < sparseArr[i].length ; j++) {
                System.out.print("\t\t"+sparseArr[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("---------稀疏数组恢复-》原始数组---------");
        int r = sparseArr[0][0];
        int c = sparseArr[0][1];
        int numberCount = sparseArr[0][2];
        int[][] res = new int[r][c];
        for (int i = 1; i < sparseArr.length; i++) {
                int i1 = sparseArr[i][0];
                int i2 = sparseArr[i][1];
                int value = sparseArr[i][2];
                res[i1][i2] = value;
        }
        for(int i=0;i < res.length;++i){
            for (int j =0;j < res[i].length;++j){
                System.out.print(res[i][j]+"  ");
            }
            System.out.println();
        }


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
