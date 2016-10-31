import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/10/31.
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()){
            return res;
        }
        int sLen = s.length(), pLen = p.length();

        int[] letters = new int[256];
        for (char c : p.toCharArray()) {
            letters[c - 'a']++;
        }

        int start = 0, end = 0, count = 0;
        while (end < sLen) {
            if (end - start == pLen && letters[s.charAt(start++) - 'a']++ >= 0) {
                count--;
            }
            if (--letters[s.charAt(end++) - 'a'] >= 0) {
                count++;
            }
            if (count == pLen) res.add(start);
        }
        return res;
    }
}
