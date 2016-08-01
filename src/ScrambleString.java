/**
 * Created by rotoosoft-d04 on 2016/8/1.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if(len != s2.length()) return false;

        boolean[][][] res = new boolean[len][len][len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int subLen = 2; subLen <= len; subLen++) {
            for (int i = 0; i <= len - subLen; i++) {
                for (int j = 0; j <= len - subLen; j++) {
                    for (int p = 1; p < subLen; p++) {
                        res[i][j][subLen] |= (res[i][j][p] && res[i + p][j + p][subLen - p])
                                || (res[i][j + subLen - p][p] && res[i + p][j][subLen - p]);
                    }
                }
            }
        }

        return res[0][0][len];
    }
}
