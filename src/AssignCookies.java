import java.util.Arrays;

/**
 * Created by zk on 2016/11/19.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (g[child] <= s[cookie]) {
                child++;
            }
            cookie++;
        }
        return child;
    }
}
