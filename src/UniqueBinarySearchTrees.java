/**
 * Created by zk on 2016/5/2.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j <= i - 1; j++) {
                sum += result[j] * result[i - 1 - j];
            }
            result[i] = sum;
        }
        return result[n];
    }
}
