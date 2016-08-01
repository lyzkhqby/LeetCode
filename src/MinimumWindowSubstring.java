import java.util.HashMap;

/**
 * Created by rotoosoft-d04 on 2016/8/1.
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0)
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        int lenS = s.length(), lenT = t.length();
        for (int i = 0; i < lenT; i++) {
            if(map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }else {
                map.put(t.charAt(i), 1);
            }
        }

        int left = 0;
        int count = 0;
        int minLen = lenS + 1;
        int minStart = 0;


        for (int right = 0; right < lenS; right++) {
            if(map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(map.get(s.charAt(right)) >= 0) count++;
                while(count == lenT) {
                    if(right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minStart = left;
                    }
                    if(map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if(map.get(s.charAt(left)) > 0) count--;
                    }
                    left++;
                }
            }
        }

        if(minLen > lenS) return "";
        return s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        minWindow("a", "a");
    }

}
