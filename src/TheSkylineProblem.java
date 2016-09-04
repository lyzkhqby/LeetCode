import java.util.*;

/**
 * Created by zk on 2016/9/5.
 */
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }

        Collections.sort(height, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });

        Queue<Integer> q = new PriorityQueue<Integer>(11, new Comparator<Integer>() {

            public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        q.offer(0);

        int prev = 0;
        for (int[] h : height) {
            if (h[1] < 0) {
                q.offer(-h[1]);
            }else {
                q.remove(h[1]);
            }
            int cur = q.peek();
            if (prev != cur) {
                res.add(new int[]{h[0], cur});
                prev = cur;
            }

        }
        return res;

    }
}
