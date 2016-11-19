import java.util.HashMap;

/**
 * Created by zk on 2016/11/19.
 */
public class ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] A) {
        int re = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            maps[i] = new HashMap<>();
            int num = A[i];
            for (int j = 0; j < i; j++) {
                if ((long)num - A[j] > Integer.MAX_VALUE) continue;
                if ((long)num - A[j] < Integer.MIN_VALUE) continue;
                int diff = num - A[j];
                int count = maps[j].getOrDefault(diff, 0);//间隔为diff 到j为止的数列
                maps[i].put(diff, maps[i].getOrDefault(diff, 0) + count + 1);//maps[i].getOr..是因为有重复， 加1是因为j到i为一个数列
                re += count;
            }
        }
        return re;

    }
}
