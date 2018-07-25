import java.util.Arrays;

/**
 * Created by rotoosoft-d04 on 2016/7/7.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int fast = 0, slow = 0, ans = 0, len = s.length();
        for (; fast < len; fast++) {
            int ch = s.charAt(fast);
            while(map[ch] != -1 && slow < fast) {
                int temp = s.charAt(slow);
                map[temp] = -1;
                slow++;
            }
            map[ch] = 0;
            ans = Math.max(ans, fast - slow + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int len = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb");
        System.out.println(len);
    }
}
