/**
 * Created by rotoosoft-d04 on 2016/11/1.
 */
public class RangeSumQueryImmutable {
    private int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        int len = nums.length;
        sum = new int[nums.length + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }

    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
