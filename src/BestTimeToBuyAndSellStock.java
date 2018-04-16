public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for (Integer price : prices) {
            min = price < min ? price : min;
            profit = (price - min) > profit ? price - min : profit;
        }

        return profit;
    }
}
