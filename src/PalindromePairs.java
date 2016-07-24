import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zk on 2016/7/25.
 */
public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;

        int len = words.length;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(words[i], i);
        }

        if(map.containsKey("")) {
            int blankIdx = map.get("");
            for (int i = 0; i < len; i++) {
                if(i == blankIdx) continue;
                if(isPalindrome(words[i])) {
                    res.add(Arrays.asList(i, blankIdx));
                    res.add(Arrays.asList(blankIdx, i));
                }
            }
        }

        for (int i = 0; i < len; i++) {
            String rev = reverseStr(words[i]);
            if(map.containsKey(rev)) {
                int revIndex = map.get(rev);
                if(revIndex == i) continue;
                res.add(Arrays.asList(i, revIndex));
            }
        }

        for (int i = 0; i < len; i++) {
            String cur = words[i];
            int curLen = cur.length();
            for (int j = 1; j < curLen; j++) {
                if(isPalindrome(cur.substring(0, j))) {
                    String curRev = reverseStr(cur.substring(j));
                    if(map.containsKey(curRev)) {
                        int revIdx = map.get(curRev);
                        res.add(Arrays.asList(revIdx, i));
                    }
                }
                if(isPalindrome(cur.substring(j))) {
                    String curRev = reverseStr(cur.substring(0, j));
                    if(map.containsKey(curRev)) {
                        int revIdx = map.get(curRev);
                        res.add(Arrays.asList(i, revIdx));
                    }
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private String reverseStr(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
