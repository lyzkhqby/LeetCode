/**
 * Created by zk on 2016/12/1.
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int min = nums[0];
        for (int num : nums) {
            if (num < min) min = num;
        }
        int count = 0;
        for (int num :nums) {
            count += num - min; //可以先按从小到大排序，然后最小的追其他的num（表现为其他的num不变，最小的加一）（如果num比最小的大1，则最上一层不变一次）
        }
        return count;
    }
}
