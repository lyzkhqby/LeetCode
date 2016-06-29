/**
 * Created by rotoosoft-d04 on 2016/6/29.
 */
public class StringToInteger {
    public int myAtoi(String str) {
        String strTrim = str.trim();
        if (strTrim.length() == 0) return 0;
        int index = 0;
        int len = strTrim.length();
        long result = 0;
        int sign = 1;
        if (strTrim.charAt(index) == '+' || strTrim.charAt(index) == '-') {
            sign = strTrim.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < len) {
            int digit = strTrim.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;
            result = result * 10 + digit;
            if (result > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }

        return (int) (result * sign);
    }
}
