import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/10/31.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        helper(res, solution, n, k, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> solution, int n, int k, int start) {
        if (solution.size() == k) {
            res.add(new ArrayList(solution));
            return;
        }
        for (int i = start; i <= n; i++) {
            solution.add(i);
            helper(res, solution, n, k, i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}
