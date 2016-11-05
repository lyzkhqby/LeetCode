import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zk on 2016/11/5.
 */
public class FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {

        if (intervals == null || intervals.length == 0) return new int[0];
        int len = intervals.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        Map<Interval, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(intervals[i], i);
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });



        for (int i = 0; i < len; i++) {
            int start = i + 1, end = len - 1;
            while (start < end) {
                int mid = (start + end) / 2;
                if (intervals[i].end > intervals[mid].start) {
                    start = mid + 1;
                }else {
                    end = mid;
                }
            }

            if (intervals[i].end <= intervals[end].start) {
                res[map.get(intervals[i])] = map.get(intervals[end]);
            }


        }

        return res;
    }
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

}
