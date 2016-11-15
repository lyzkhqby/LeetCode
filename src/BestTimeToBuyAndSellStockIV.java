/**
 * Created by rotoosoft-d04 on 2016/11/15.
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) return 0;
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int n = prices.length;
        int[][] mustsell = new int[n][n]; // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] globalbest = new int[n][n]; // globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益

        mustsell[0][0] = globalbest[0][0] = 0;
        for (int i = 0; i <= k; i++) {
            mustsell[0][i] = globalbest[0][i] = 0;
        }
        for (int i = 1; i < n; i++) {
            int gainorlose = prices[i] - prices[i - 1];
            mustsell[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                mustsell[i][j] = Math.max(globalbest[i - 1][j - 1] + gainorlose,
                        mustsell[i - 1][j] + gainorlose);
                globalbest[i][j] = Math.max(globalbest[i - 1][j], mustsell[i][j]);
            }
        }
        return globalbest[n - 1][k];
    }
}

//特殊动态规划法。传统的动态规划我们会这样想，到第i天时进行j次交易的最大收益，要么等于到第i-1天时进行j次交易的最大收益（第i天价格低于第i-1天的价格），
//        要么等于到第i-1天时进行j-1次交易，然后第i天进行一次交易（第i天价格高于第i-1天价格时）。于是得到动规方程如下（其中diff = prices[i] – prices[i – 1]）：
//
//        profit[i][j] = max(profit[i – 1][j], profit[i – 1][j – 1] + diff)
//        看起来很有道理，但其实不对，为什么不对呢？因为diff是第i天和第i-1天的差额收益，如果第i-1天当天本身也有交易呢（也就是说第i-1天刚卖出了股票，
//        然后又买入等到第i天再卖出），那么这两次交易就可以合为一次交易，这样profit[i – 1][j – 1] + diff实际上只进行了j-1次交易，而不是最多可以的j次，
//        这样得到的最大收益就小了。
//
//        那么怎样计算第i天进行交易的情况的最大收益，才会避免少计算一次交易呢？我们用一个局部最优解和全局最有解表示到第i天进行j次的收益，这就是该动态规划的特殊之处。
