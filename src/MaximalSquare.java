/**
 * Created by zk on 2016/11/4.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rowLen = matrix.length, colLen = matrix[0].length;
        int[][] b = new int[rowLen + 1][colLen + 1];
        int result = 0;
        for (int i = 1; i <= rowLen; i++) {
            for (int j = 1; j <= colLen; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;
                    result = Math.max(b[i][j], result);
                }
            }
        }
        return result * result;
    }
}
