import java.util.TreeSet;

/**
 * Created by rotoosoft-d04 on 2016/8/15.
 */
public class MaxSumOfRectangleNoLargerThanK {
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = 0;
        if (m > 0) n = matrix[0].length;
        if (m * n == 0) return 0;

        int M = Math.max(m, n);
        int N = Math.min(m, n);

        int ans = Integer.MIN_VALUE;
        for (int x = 0; x < N; x++) {
            int sums[] = new int[M];
            for (int y = x; y < N; y++) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                int num = 0;
                for (int z = 0; z < M; z++) {
                    sums[z] += m > n ? matrix[z][y] : matrix[y][z];
                    num += sums[z];
                    if (num <= k) ans = Math.max(ans, num);
                    Integer i = set.ceiling(num - k);
                    if (i != null) ans = Math.max(ans, num - i);
                    set.add(num);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] nums = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        maxSumSubmatrix(nums, 10);
    }
}
