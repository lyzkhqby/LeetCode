/**
 * Created by zk on 2016/11/13.
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < len; i++) {
            two |= (one & nums[i]);
            one ^= nums[i];
            three = one & two;
            two -= three;
            one -=three;
        }
        return one;
    }
}
