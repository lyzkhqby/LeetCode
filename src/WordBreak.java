import java.util.Set;

/**
 * Created by rotoosoft-d04 on 2016/11/2.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        int sLen = s.length();
        int maxLength = getMaxLength(wordDict);
        boolean[] canSegment = new boolean[sLen + 1];
        canSegment[0] = true;
        for (int i = 1; i <= sLen; i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1;
                 lastWordLength <= maxLength && lastWordLength <= i;
                 lastWordLength++) {
                if (!canSegment[i - lastWordLength]) continue;
                String word = s.substring(i - lastWordLength, i);
                if (wordDict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }

        return canSegment[sLen];
    }

    private int getMaxLength(Set<String> wordDict) {
        int res = 0;
        for (String word : wordDict) {
            res = Math.max(res, word.length());
        }
        return res;
    }
}
