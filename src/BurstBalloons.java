/**
 * Created by zk on 2016/10/28.
 */
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int lenNums = nums.length;
        int[][] dp = new int[lenNums][lenNums];

        for (int len = 1; len <= lenNums; len++) {
            for (int start = 0; start <= lenNums - len; start++) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                    coins += (i == start) ? 0 : dp[start][i - 1];
                    coins += (i == end) ? 0 : dp[i + 1][end];
                    dp[start][end] = Math.max(dp[start][end], coins);
                }
            }
        }
        return dp[0][lenNums - 1];
    }

    private int getValue(int[] nums, int index) {
        if (index < 0 || index >= nums.length) return 1;
        return nums[index];
    }
}
