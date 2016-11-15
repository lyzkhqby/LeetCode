/**
 * Created by zk on 2016/11/15.
 */
public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            for (int j = 0; j < m; j++) {
                elements[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((elements[i] & elements[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }
}
