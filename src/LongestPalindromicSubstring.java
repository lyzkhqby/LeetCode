/**
 * Created by rotoosoft-d04 on 2016/7/6.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        String res = "";
        int maxLen = 0;
        int len = s.length();
        boolean[][] palin  = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || palin[i + 1][j - 1])) {
                    palin[i][j] = true;
                    if(maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
