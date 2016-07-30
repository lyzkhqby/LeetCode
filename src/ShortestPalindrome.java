/**
 * Created by zk on 2016/7/30.
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int j = 0;
        int len = s.length();
        for(int i = len - 1; i >= 0 ; i--) {
            if(s.charAt(j) == s.charAt(i)) {
                j++;
            }
        }

        if(j == len) return s;

        String suffix = s.substring(j);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, j));
        return prefix + mid + suffix;
    }
}
