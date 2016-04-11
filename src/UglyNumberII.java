import java.util.PriorityQueue;

/**
 * Created by rotoosoft-d04 on 2016/4/11.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        if(n == 1) return 1;
        PriorityQueue<Long> q = new PriorityQueue<Long>();
        int[] nums = {2, 3, 5};
        Long result = Long.valueOf(1);
        q.offer(result);
        for (int i = 0; i < n; i++) {
            result = q.poll();
            for (int num : nums) {
                Long uglyNumber = result * num;
                if (!q.contains(uglyNumber)) {
                    q.offer(uglyNumber);
                }
            }
        }
        return result.intValue();

    }
}
