/**
 * Created by zk on 2016/9/15.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            c ^= s.charAt(i) ^ t.charAt(i);
        }
        return c;
    }
}
