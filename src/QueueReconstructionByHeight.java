import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zk on 2016/11/20.
 */
public class QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        int len = people.length;
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }

        int[][] res = new int[len][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i][1] = k[1];
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(people);
    }
}
