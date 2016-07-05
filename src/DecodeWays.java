/**
 * Created by rotoosoft-d04 on 2016/7/5.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] memo = new int[len + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            if(s.charAt(i - 1) != '0') {
                memo[i] = memo[i - 1];
            }
            int digit = Integer.parseInt(s.substring(i - 2, i));
            if(digit >= 10 && digit <= 26) {
                memo[i] += memo[i - 2];
            }
        }
        return memo[len];

    }
}
