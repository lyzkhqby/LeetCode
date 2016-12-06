import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by rotoosoft-d04 on 2016/12/6.
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {

            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            }
        });

        int minArrows = 1;
        int arrowLimit = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] <= arrowLimit) {
                arrowLimit = Math.min(arrowLimit, point[1]);
            }else {
                minArrows++;
                arrowLimit = point[1];

            }
        }
        return minArrows;
    }
}
