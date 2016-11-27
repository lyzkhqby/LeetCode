import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/11/27.
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int cur, int n, List<Integer> res) {
        if (cur > n) {
            return;
        }else {
            res.add(cur);
            for (int i = 0; i < 10; i++) {
                if (cur * 10 + i > n) {
                    break;
                }else {
                    dfs(cur * 10 + i, n, res);
                }
            }
        }
    }
}
