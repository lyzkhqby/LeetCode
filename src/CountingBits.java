/**
 * Created by rotoosoft-d04 on 2016/11/15.
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int temp = i / 2;
            if (i % 2 == 0) {
                dp[i] = dp[temp];
            }else {
                dp[i] = dp[temp] + 1;
            }
        }
        return dp;
    }
}
