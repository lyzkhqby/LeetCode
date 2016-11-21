import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/11/21.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 1) {
            for (int i = 0; i <= n; i++) {
                res.add(i);
            }
            return res;
        }
        res = grayCode(n - 1);
        List<Integer> r1 = reverse(res);
        int x = 1 << (n - 1);
        for (int i = 0; i < r1.size(); i++) {
            r1.set(i, r1.get(i) + x);
        }
        res.addAll(r1);
        return res;
    }

    private List<Integer> reverse(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.add(list.get(i));
        }
        return res;
    }
}
