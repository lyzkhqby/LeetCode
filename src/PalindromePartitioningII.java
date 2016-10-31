/**
 * Created by zk on 2016/11/1.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        boolean[][] isPalindrome = getIsPalindrome(s);
        int[] f = new int[len + 1];
        f[0] = 0;

        for (int i = 1; i <= len; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[len] - 1;
    }

    private boolean[][] getIsPalindrome(String s) {
        int len = s.length();
        boolean[][] res = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = true;
        }

        for (int i = 0; i < len - 1; i++) {
            res[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < len; length++) {
            for (int start = 0; start + length < len; start++) {
                res[start][start + length] = res[start + 1][start + length - 1]
                        && (s.charAt(start) == s.charAt(start + length));
            }
        }
        return res;
    }
}
