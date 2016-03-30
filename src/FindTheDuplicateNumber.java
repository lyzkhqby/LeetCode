/**
 * Created by rotoosoft-d04 on 2016/3/30.
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int start = 0, end = nums.length;
        while(start < end) {
            int mid = (start + end) / 2;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
