import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/11/10.
 */
public class DataStreamAsDisjointIntervals {
    private List<Interval> list;
    /** Initialize your data structure here. */
    public DataStreamAsDisjointIntervals() {
        list = new ArrayList<>();
    }

    public void addNum(int val) {
        if (list.isEmpty()) {
            list.add(new Interval(val, val));
            return;
        }
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            Interval mid = list.get(m);
            if (mid.start <= val && val <= mid.end) return;
            if (mid.start < val) i = m + 1;
            else j = m - 1;
        }
        Interval target = (i == list.size()) ? null : list.get(i);
        Interval left = (i == 0) ? null : list.get(i - 1);
        if (i == 0) {
            if (val + 1 == target.start) {
                target.start = val;
                return;
            }
            list.add(0, new Interval(val, val));

        }else if (i == list.size()) {
            if (left.start <= val && val <= left.end) return;
            if (left.end + 1 == val) {
                left.end = val;
                return;
            }
            list.add(new Interval(val, val));

        }else {
            if (target.start <= val && val <= target.end) return;
            if (left.start <= val && val <= left.end) return;
            if (left.end + 1 < val && val + 1 < target.start) {
                list.add(i, new Interval(val, val));
                return;
            }
            if (left.end + 1 == val) {
                left.end = val;
            }
            if (val + 1 == target.start) {
                target.start = val;
            }
            if (left.end == target.start) {
                left.end = target.end;
                list.remove(i);
            }
        }

    }

    public List<Interval> getIntervals() {
        return list;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
