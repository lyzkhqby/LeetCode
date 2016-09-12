/**
 * Created by rotoosoft-d04 on 2016/9/12.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
