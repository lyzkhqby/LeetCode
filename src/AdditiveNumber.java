/**
 * Created by rotoosoft-d04 on 2016/11/8.
 */
public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
            if (num.charAt(0) == '0' && i > 1) return false;
            for (int j = i + 1; j < num.length(); j++) {
                if (num.charAt(i) == '0' && j - i > 1) continue;//"198019823962"不能为return false的例子
                if (dfs(num, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean dfs(String num, int i, int j, int k) {
        long num1 = Long.parseLong(num.substring(i, j));
        long num2 = Long.parseLong(num.substring(j, k));
        String addition = String.valueOf(num1 + num2);

        if (!num.substring(k).startsWith(addition)) return false;
        if (k + addition.length() == num.length()) return true;
        return dfs(num, j, k, k + addition.length());
    }
}
