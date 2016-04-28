/**
 * Created by zk on 2016/4/28.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int fIndex = 0, lIndex = -1;
        for (; fIndex < len; fIndex++) {
            if (nums[fIndex] != val) {
                lIndex++;
                int temp = nums[fIndex];
                nums[fIndex] = nums[lIndex];
                nums[lIndex] = temp;

            }
        }
        return lIndex + 1;
    }
}
