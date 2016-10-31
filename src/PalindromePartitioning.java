import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/11/1.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<String> path = new ArrayList<>();
        helper(res, path, 0, s);
        return res;

    }

    private void helper(List<List<String>> res, List<String> path, int pos, String s) {
        int sLen = s.length();
        if (pos == sLen) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = pos + 1; i <= sLen; i++) {
            String prefix = s.substring(pos, i);
            if (!isPalindrome(prefix)) {
                continue;
            }
            path.add(prefix);
            helper(res, path, i, s);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
