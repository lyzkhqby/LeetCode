import java.util.TreeSet;

/**
 * Created by zk on 2016/8/17.
 */
public class MaxSumOfRectangleNoLargerThanK {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = 0;
        if (m > 0) n = matrix[0].length;
        if (m * n == 0) return 0;

        int M = Math.max(m, n);
        int N = Math.min(m, n);

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int sums[] = new int[M];
            for (int j = i; j < N; j++) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                int num = 0;
                for (int p = 0; p < M; p++) {
                    sums[p] += m > n ? matrix[p][j] : matrix[j][p];
                    num += sums[p];
                    if (num <= k) res = Math.max(res, num);
                    Integer x = set.ceiling(num - k);
                    if (x != null) res = Math.max(res, num - x);
                    set.add(num);
                }
            }
        }

        return res;


    }
}
