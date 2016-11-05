import java.util.Arrays;

/**
 * Created by zk on 2016/11/5.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null && nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            int sum = 0;
            for (int j = 0; j < len && nums[j] <= i; j++) {
                sum += dp[i - nums[j]];
            }
            dp[i] = sum;
        }
        return dp[target];
    }
}
