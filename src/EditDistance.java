/**
 * Created by zk on 2016/7/21.
 */
public class EditDistance {
//    处理这道题也是用动态规划。
//
//
//    动态数组dp[word1.length+1][word2.length+1]
//
//    dp[i][j]表示从word1前i个字符转换到word2前j个字符最少的步骤数。
//
//    假设word1现在遍历到字符x，word2遍历到字符y（word1当前遍历到的长度为i，word2为j）。
//
//    以下两种可能性：
//
//            1. x==y，那么不用做任何编辑操作，所以dp[i][j] = dp[i-1][j-1]
//
//            2. x != y
//
//            (1) 在word1插入y， 那么dp[i][j] = dp[i][j-1] + 1
//
//
//            (2) 在word1删除x， 那么dp[i][j] = dp[i-1][j] + 1
//
//
//            (3) 把word1中的x用y来替换，那么dp[i][j] = dp[i-1][j-1] + 1
//
//    最少的步骤就是取这三个中的最小值。
//
//    最后返回 dp[word1.length+1][word2.length+1] 即可。

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i -1][j]));
                }
            }
        }
        return dp[n][m];
    }
}
