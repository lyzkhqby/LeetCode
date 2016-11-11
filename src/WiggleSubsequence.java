/**
 * Created by rotoosoft-d04 on 2016/11/11.
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int p = 1, q = 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) p = q + 1;
            else if (nums[i] < nums[i - 1]) q = p + 1;
        }
        return Math.min(len, Math.max(p, q));
    }
}
