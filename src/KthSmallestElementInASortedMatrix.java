/**
 * Created by rotoosoft-d04 on 2016/8/11.
 */
public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;

        int lower = matrix[0][0];
        int upper = matrix[len - 1][len - 1];

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            int count = count(matrix, mid);
            if(count < k) {
                lower = mid + 1;
            }else {
                upper = mid;
            }
        }
        return upper;
    }

    private int count(int[][] matrix, int target) {
        int len = matrix.length;
        int i = len - 1, j = 0;
        int count = 0;
        while(i >= 0 && j < len) {
            if (matrix[i][j] <= target) {
                count += i + 1;
                j++;
            }else {
                i--;
            }
        }
        return count;
    }
}
