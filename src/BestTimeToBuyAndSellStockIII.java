/**
 * Created by zk on 2016/4/6.
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int max = 0;
        int[] left = new int[len];
        int[] right = new int[len];

        int minPrices = prices[0];
        left[0] = 0;
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i-1], prices[i] - minPrices);
            minPrices = Math.min(minPrices, prices[i]);
        }

        int maxSell = prices[len - 1];
        right[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxSell - prices[i]);
            maxSell = Math.max(maxSell, prices[i]);
        }


        for (int i = 0; i < len; i++) {
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }
}
