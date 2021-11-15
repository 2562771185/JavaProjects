package 力扣;

/**
 * @PACKAGE_NAME: 力扣
 * @author: JHZZ
 * @date: 2021/11/11 12:44
 * @PROJECT_NAME: JavaProjects
 */
public class p566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat[0].length * mat.length != r * c) return mat;
        int m=mat.length;
        int n =mat[0].length;
        int[][] res = new int[r][c];
        for(int i=0;i < m*n;i++){
            res[i/c][i%c] = mat[i / n][i % n];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
