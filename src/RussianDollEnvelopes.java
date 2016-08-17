import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zk on 2016/8/18.
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                return x[0] - y[0];
            }
        });

        int[] f = new int[envelopes.length];
        Arrays.fill(f, 1);
        int len = envelopes.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int k = i - 1; k >= 0; k--) {
                if (envelopes[k][0] < envelopes[i][0] && envelopes[k][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[k] + 1);
                }
            }
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
