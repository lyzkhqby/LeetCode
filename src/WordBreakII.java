import java.util.*;

/**
 * Created by rotoosoft-d04 on 2016/11/1.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, ArrayList<String>> memo = new HashMap<>();
        return helper(s, wordDict, memo);
    }

    private ArrayList<String> helper(String s, Set<String> wordDict, Map<String, ArrayList<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        ArrayList<String> res = new ArrayList<>();
        int sLen = s.length();
        if (sLen <= 0) return res;
        for (int length = 1; length <= sLen; length++) {
            String prefix = s.substring(0, length);
            if (wordDict.contains(prefix)) {
                if (length == sLen) {
                    res.add(prefix);
                }else {
                    String suffix = s.substring(length);
                    ArrayList<String> temp = helper(suffix, wordDict, memo);
                    for (String tmp : temp) {
                        String item = prefix + " " + tmp;
                        res.add(item);
                    }
                }

            }
        }
        memo.put(s, res);
        return res;
    }
}
