/**
 * Created by rotoosoft-d04 on 2016/6/27.
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;

        int len = haystack.length() - needle.length() + 1;
        for (int i = 0; i < len; i++) {
            int needleLen = needle.length();
            int j = 0;
            for (; j < needleLen; j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needleLen) return i;
        }
        return -1;
    }
}
