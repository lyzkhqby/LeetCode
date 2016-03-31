/**
 * Created by rotoosoft-d04 on 2016/3/31.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        int len = intervals.size();
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; i++) {
            Interval interval = intervals.get(i);
            starts[i] = interval.start;
            ends[i] = interval.end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0, j = 0; i < len; i++) {
            if (i == len - 1 || starts[i + 1] > ends[i]) {
                list.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return list;
    }

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}


