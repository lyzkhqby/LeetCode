import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rotoosoft-d04 on 2016/8/31.
 */
public class FindMedianFromDataStream {

    PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }


    }

    // Returns the median of current data stream
    public double findMedian() {
        return max.size() == min.size() ? (double)(min.peek() + max.peek()) / 2.0: max.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();

