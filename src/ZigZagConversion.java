/**
 * Created by zk on 2016/6/18.
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int len = s.length(), interval = numRows * 2 - 2;
        String res = "";
        for (int i = 0; i < len; i += interval) {
            res += s.charAt(i);
        }
        for (int i = 1; i < numRows - 1; i++) {
            int j = i;
            boolean isEven = true;
            while (j < len) {
                res += s.charAt(j);
                if(isEven) {
                    j += interval - 2 * i;
                    isEven = false;
                }else {
                    j += 2 * i;
                    isEven = true;
                }
            }

        }
        for (int i = numRows - 1; i < len; i += interval) {
            res += s.charAt(i);
        }
        return res;
    }
}
