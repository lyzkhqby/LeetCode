/**
 * Created by rotoosoft-d04 on 2016/7/28.
 */
public class WildcardMatching {
//    p[j-1] == s[i-1] || p[j-1] == '?'：dp[i][j] = dp[i-1][j-1]
//    p[j-1] == '*'：
//            1. 匹配0个字符：dp[i][j] = dp[i][j-1]
//            2. 匹配1个字符：dp[i][j] = dp[i-1][j-1]
//            3. 匹配多个字符：dp[i][j] = dp[i-1][j]
    public boolean isMatch(String s, String p) {
        int lenS = s.length(), lenP = p.length();

        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;

        for (int i = 0; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++) {
                if(i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || (i > 0 && (dp[i - 1][j - 1] || dp[i - 1][j]));
                }
            }
        }

        return dp[lenS][lenP];
    }
}
