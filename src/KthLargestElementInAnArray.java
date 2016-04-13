import java.util.PriorityQueue;

/**
 * Created by rotoosoft-d04 on 2016/4/13.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<Long>();
        for (int num : nums) {
            q.offer(Long.valueOf(num));
        }
        Long result = null;
        int len = nums.length;
        for (int i = 1; i <= len - k + 1; i++) {
            result = q.poll();
        }
        return result.intValue();
    }

}
