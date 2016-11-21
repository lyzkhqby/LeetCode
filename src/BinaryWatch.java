import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/11/18.
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                int total = countDigits(i) + countDigits(j);
                if (total == num) {
                    String s = "";
                    s += i + ":";
                    if (j < 10) {
                        s += "0" + j;
                    }
                    else {
                        s += j;
                    }
                    res.add(s);
                }

            }
        }
        return res;
    }

    private int countDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum++;
            num &= (num - 1);

        }
        return sum;
    }
}
