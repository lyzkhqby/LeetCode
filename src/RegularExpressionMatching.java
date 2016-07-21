/**
 * Created by zk on 2016/7/22.
 */
public class RegularExpressionMatching {
//    关键在于如何处理这个'*'号。
//
//    状态：和Mininum Edit Distance这类题目一样。
//    dp[i][j]表示s[0:i-1]是否能和p[0:j-1]匹配。
//
//    递推公式：由于只有p中会含有regular expression，所以以p[j-1]来进行分类。
//    p[j-1] != '.' && p[j-1] != '*'：dp[i][j] = dp[i-1][j-1] && (s[i-1] == p[j-1])
//    p[j-1] == '.'：dp[i][j] = dp[i-1][j-1]
//
//    而关键的难点在于 p[j-1] = '*'。由于星号可以匹配0，1，乃至多个p[j-2]。
//            1. 匹配0个元素，即消去p[j-2]，此时p[0: j-1] = p[0: j-3]
//    dp[i][j] = dp[i][j-2]
//
//            2. 匹配1个元素，此时p[0: j-1] = p[0: j-2]
//    dp[i][j] = dp[i][j-1]
//
//            3. 匹配多个元素，此时p[0: j-1] = { p[0: j-2], p[j-2], ... , p[j-2] }
//    dp[i][j] = dp[i-1][j] && (p[j-2]=='.' || s[i-1]==p[j-2])
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        boolean[][] d = new boolean[m + 1][n + 1];
        d[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j - 1) != '.' && p.charAt(j - 1) != '*') {
                    if(i>0 && s.charAt(i - 1) == p.charAt(j - 1) && d[i - 1][j - 1]) {
                        d[i][j] = true;
                    }
                }else if(p.charAt(j - 1) == '.') {
                    if(i>0 && d[i - 1][j -1]) {
                        d[i][j] = true;
                    }
                }else if(j > 1) {
                    if(d[i][j - 1] || d[i][j - 2]) {
                        d[i][j] = true;
                    }else if(i>0 && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') && d[i - 1][j]) {
                        d[i][j] = true;
                    }
                }
            }
        }

        return d[m][n];
    }
}
