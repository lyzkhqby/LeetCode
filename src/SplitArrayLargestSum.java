/**
 * Created by rotoosoft-d04 on 2016/11/15.
 */
public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int m) {
        int[] dp = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = (i == nums.length - 1) ? nums[i] : dp[i + 1] + nums[i];
        }

        for (int im = 2; im <= m ; im++) {
            int maxPart = nums.length + 1 - im;
            for (int i = 0; i < maxPart; i++) {
                dp[i] = Integer.MAX_VALUE;
                int leftSum = 0;
                for (int p = i; p < maxPart; p++) {
                    leftSum += nums[p];
                    if (dp[i] < leftSum) break;
                    int val = Math.max(leftSum, dp[p + 1]);
                    if (val < dp[i]) dp[i] = val;
                }
                if (im == m) {
                    break;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] attrs = {7, 2, 5, 10 , 8};
        System.out.print(splitArray(attrs, 3));
    }
}
