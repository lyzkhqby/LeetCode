import java.util.ArrayList;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by rotoosoft-d04 on 2016/8/29.
 */
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(final int[] nums1, final int[] nums2, int k) {

        List<int[]> res = new ArrayList<int[]>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return res;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

            public int compare(int[] pair1, int[] pair2) {
                return (nums1[pair1[0]] + nums2[pair1[1]]) - (nums1[pair2[0]] + nums2[pair2[1]]);
            }

        });

        queue.offer(new int[]{0, 0});

        while (k > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            int i = pair[0];
            int j = pair[1];
            res.add(new int[]{nums1[i], nums2[j]});
            k--;

            if (j + 1 < nums2.length) {
                queue.offer(new int[]{i, j + 1});
            }

            if (j == 0 && i + 1< nums1.length) {
                queue.offer(new int[]{i + 1, 0});
            }
        }

        return res;

    }
}
