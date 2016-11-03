/**
 * Created by zk on 2016/11/3.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robber(nums, 0, nums.length - 2), robber(nums, 1, nums.length - 1));


    }

    public int robber(int[] nums, int start, int end) {
        int[] res = new int[2];
        if (start == end) return nums[end];
        if (start + 1 == end) return Math.max(nums[start], nums[end]);
        res[start % 2] = nums[start];
        res[(start + 1) % 2] = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            res[i % 2] = Math.max(res[(i - 1) % 2], res[(i - 2) % 2] + nums[i]);
        }

        return res[end % 2];
    }
}
