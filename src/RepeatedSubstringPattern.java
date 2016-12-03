/**
 * Created by zk on 2016/12/3.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        int n = str.length(), cur = 0, j = 1;
        int[] pattern = new int[n];
        while (j < n) {
            if (str.charAt(cur) == str.charAt(j)) {
                pattern[j++] = ++cur; //注意是“循环”
            }else {
                if (cur == 0) pattern[j++] = 0;
                else cur = pattern[cur - 1]; /* start from beginning of current matching pattern */
            }
        }
        return (pattern[n - 1] > 0 && n % (n - pattern[n - 1]) == 0);
    }
}

//测试用例[a, b, a, b, a, b, b, a, b, a, b, a, b, b]