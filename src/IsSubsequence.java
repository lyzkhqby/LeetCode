/**
 * Created by zk on 2016/11/4.
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen == 0) return true;
        int indexS = 0, indexT = 0;
        while(indexT < tLen) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                if (indexS == sLen - 1) return true;
                indexS++;
            }
            indexT++;
        }
        return false;
    }
}
