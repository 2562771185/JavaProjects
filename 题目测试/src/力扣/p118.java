package 力扣;

import java.util.ArrayList;
import java.util.List;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/11 13:00
 * @PROJECT_NAME: JavaProjects
 */
public class p118 {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return null;

        List<List<Integer>> res = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        //List<Integer> list = new ArrayList<>();
        //list.add(1);
        //res.add(list);
        for(int i=0;i<numRows;++i){
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;j <= i;j++){
                if(j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                tmp.add(dp[i][j]);
            }
            res.add(tmp);
        }
        return res;
    }
}
