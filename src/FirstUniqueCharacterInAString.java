/**
 * Created by zk on 2016/11/1.
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        int len = s.length();
        int[] freq = new int[256];
        for (int i = 0; i < len; i++)
            freq[s.charAt(i) - 'a']++;
        for (int i = 0; i < len; i++)
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
