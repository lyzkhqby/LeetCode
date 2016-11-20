/**
 * Created by zk on 2016/11/20.
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int count = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            }else {
                miss += miss;
                count++;
            }
        }
        return count;
    }
}
