/**
 * Created by zk on 2016/11/12.
 */
public class GuessNumberHigherOrLowerII {

    public int getMoneyAmount(int n) {
        if (n == 1) return 0;
        int[][] dp = new int[n + 1][n + 1];

        for (int jminusi = 1; jminusi < n; jminusi++) {
            for (int i = 0; i <= n - jminusi; i++) {
                int j = i + jminusi;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(k - 1 >= i ? dp[i][k - 1] : 0,
                            k + 1 <= j ? dp[k + 1][j] : 0));
                }
            }
        }
        return dp[1][n];

    }
}
