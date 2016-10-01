/**
 * Created by zk on 2016/10/1.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(len - i - 1);
            res += (c - 'A' + 1) * Math.pow(26, i);
        }
        return res;
    }
}
