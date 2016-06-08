import java.util.Arrays;

/**
 * Created by zk on 2016/6/9.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.length() == 0 && t.length() == 0) return true;
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ts);
        int len = cs.length;
        for (int i = 0; i < len; i++) {
            if(cs[i] != ts[i]) {
                return false;
            }
        }
        return true;
    }
}
