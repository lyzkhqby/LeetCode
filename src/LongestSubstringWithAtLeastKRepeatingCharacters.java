import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/12/7.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;
        int[] count = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] < k) pos.add(i);
        }
        if (pos.size() == 0) return s.length();
        pos.add(0, -1);
        pos.add(s.length());
        for (int i = 1; i < pos.size(); i++) {
            int start = pos.get(i - 1) + 1;
            int end = pos.get(i);
            int next = longestSubstring(s.substring(start, end), k);
            res = Math.max(res, next);
        }
        return res;
    }
}
