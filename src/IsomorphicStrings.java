/**
 * Created by zk on 2016/9/14.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if (len <= 1) return true;

        int[] sToT = new int[256];
        int[] tToS = new int[256];
        char[] sValue = s.toCharArray();
        char[] tValue = t.toCharArray();

        for (int i = 0; i < len; i++) {
            if (sToT[sValue[i]] == 0 && tToS[tValue[i]] == 0) {
                sToT[sValue[i]] = tValue[i];
                tToS[tValue[i]] = sValue[i];
            }else if(sToT[sValue[i]] != tValue[i] || tToS[tValue[i]] != sValue[i]) {
                return false;
            }
        }

        return true;
    }
}
