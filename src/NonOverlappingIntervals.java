import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by rotoosoft-d04 on 2016/12/6.
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        int end = Integer.MIN_VALUE;
        int count = 0;
        for (Interval interval : intervals) {
            if (interval.start >= end) end = interval.end;
            else count++;
        }
        return count;

    }
    public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }

}
