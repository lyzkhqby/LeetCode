public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices == null & prices.length ==0) return 0;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int dif = prices[i + 1] - prices[i];
            if (dif > 0) {
                profit += dif;
            }
        }
        return profit;
    }
}
