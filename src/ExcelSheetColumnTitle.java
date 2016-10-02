/**
 * Created by zk on 2016/10/2.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        String res = "";
        while (n != 0) {
            char c = (char)((n - 1) % 26 + 'A');
            n = (n - 1) / 26;
            res = c + res;
        }
        return res;
    }
}
