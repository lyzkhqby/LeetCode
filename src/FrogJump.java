import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zk on 2016/11/16.
 */
public class FrogJump {
    public static boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] maxMap = new int[stones.length];
        // store accumulative max step to prune
        map.put(0, new HashSet<>());
        map.get(0).add(0);

        for (int i = 1; i < stones.length; i++) {
            Set<Integer> set = new HashSet<>();
            // how many ways can frog get to stone i
            // hashset stores the steps took
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                int step = stones[i] - stones[j];
                if (step > maxMap[j] + 1) // essential, or else will TLE
                    continue;
                if (map.get(j).contains(step - 1) || map.get(j).contains(step) || map.get(j).contains(step + 1)) {
                    set.add(step);
                    max = Math.max(max, step);
                }
            }
            map.put(i, set);
            maxMap[i] = max;
        }
        return map.get(stones.length - 1).size() > 0;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,6,10,15,16,21};
        System.out.print(canCross(stones));
    }

}
