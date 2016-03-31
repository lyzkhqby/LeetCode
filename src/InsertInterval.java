import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/3/31.
 */
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();

        int len = intervals.size();
        int[] starts = new int[len + 1];
        int[] ends = new int[len + 1];
        for (int i = 0; i < len; i++) {
            Interval interval = intervals.get(i);
            starts[i] = interval.start;
            ends[i] = interval.end;
        }
        starts[len] = newInterval.start;
        ends[len] = newInterval.end;

        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int i = 0, j = 0; i < len + 1; i++) {
            if (i == len || starts[i + 1] > ends[i]) {
                list.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }

        return list;
    }
}

class Interval1 {
    int start;
    int end;
    Interval1() { start = 0; end = 0; }
    Interval1(int s, int e) { start = s; end = e; }
     }
