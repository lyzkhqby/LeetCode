/**
 * Created by rotoosoft-d04 on 2016/7/27.
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        int lenS = s.length(), lenT = t.length();
        int[][] nums = new int[lenS + 1][lenT + 1];
        for (int i = 0; i <= lenS; i++) {
            nums[i][0] = 1;
        }
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenT; j++) {
                nums[i][j] = nums[i - 1][j];
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }

        return nums[lenS][lenT];
    }
}
