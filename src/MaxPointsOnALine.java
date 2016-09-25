import java.util.HashMap;

/**
 * Created by zk on 2016/9/25.
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;

        int max = 1;
        HashMap<Double, Integer> map = new HashMap<>();
        int len = points.length;

        for (int i = 0; i < len; i++) {
            map.clear();
            map.put((double)Integer.MIN_VALUE, 1);
            int dup = 0;
            for (int j = i + 1; j < len; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                }

                double key = (points[j].x - points[i].x == 0) ? Integer.MAX_VALUE
                        : 0.0 + (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);

                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                }else {
                    map.put(key, 2);
                }
            }
            for (int temp : map.values()) {
                if (temp + dup > max) max = temp + dup;
            }
        }

        return max;
    }

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }
}
