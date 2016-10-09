/**
 * Created by rotoosoft-d04 on 2016/10/9.
 */
public class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        int len = x.length;
        for (int i = 3; i < len; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
            else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) return true;
            else if (i >= 5 && x[i - 2] >= x[i - 4] && x[i] >= x[i - 2] - x[i - 4]
                    && x[i - 1] <= x[i - 3] && x[i - 1] >= x[i - 3] - x[i - 5]) return true;
        }
        return false;
    }
}
