import java.util.Random;

/**
 * Created by rotoosoft-d04 on 2016/11/7.
 */
public class RandomPickIndex {
    int[] nums;
    Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int len = nums.length;
        int count = 1;
        int res = -1;
        for (int i = 0; i < len; i++) {
            if (target == nums[i]) {
                if(random.nextInt(count) == 0) {
                    res = i;
                }
                count++;
            }
        }
        return res;
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int param_1 = obj.pick(target);
     */
}
