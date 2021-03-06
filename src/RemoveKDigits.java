/**
 * Created by rotoosoft-d04 on 2016/12/7.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stk[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            stk[top++] = c; //保持最小
        }
        int idx = 0;
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits ? "0" : new String(stk, idx, digits - idx);
    }
}
