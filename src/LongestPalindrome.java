/**
 * Created by rotoosoft-d04 on 2016/10/27.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int['z' - 'A' + 1];
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) count[s.charAt(i) - 'A']++;
        for (int n : count) ans += n / 2;
        return Math.min(ans * 2 + 1, len);
    }
}
