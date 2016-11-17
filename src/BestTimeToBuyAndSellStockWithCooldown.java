/**
 * Created by zk on 2016/11/17.
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int len = prices.length;
        if (len < 2) return 0;
        int[] dp = new int[len];
        dp[1] = Math.max(0, prices[1] - prices[0]);
        int loseMin = Math.min(prices[0], prices[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - loseMin);
            loseMin = Math.min(loseMin, prices[i] - dp[i - 2]);
        }
        return dp[len - 1];
    }
    //profit = gain - lose;
}
