import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by rotoosoft-d04 on 2016/9/1.
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) return null;
        if (nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();

        for (int i = 0; i < k - 1; i++) {
            inQueue(deque, nums[i]);
        }

        for (int i = k - 1; i < nums.length; i++) {
            inQueue(deque, nums[i]);
            res[i - k + 1] = deque.peekFirst();
            outQueue(deque, nums[i - k + 1]);
        }
        return res;
    }

    private void inQueue(Deque<Integer> deque, int num) {
        while(!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    }

    private void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }
}
