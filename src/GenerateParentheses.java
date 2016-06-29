import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/6/29.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", n, 0, 0);
        return ans;
    }

    private void dfs(List<String> ans, String curr, int n, int l, int r) {
        if (l == n && r == n) {
            ans.add(curr);
            return;
        }
        if(l < n) {
            dfs(ans, curr + "(", n, l + 1, r);
        }
        if(r < l) {
            dfs(ans, curr + ")", n, l, r + 1);
        }
    }
}
