import java.util.Arrays;

/**
 * Created by zk on 2016/4/5.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        int area = 0;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], l);
                }else {
                    l = j + 1;
                    height[j] = 0;
                    left[j] = 0;
                    right[j] = n;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(r, right[j]);
                    area = Math.max(area, height[j] * (right[j] - left[j]));

                }else {
                    r = j;
                }
            }

        }
        return area;

    }
}
