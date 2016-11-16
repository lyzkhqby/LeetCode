import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rotoosoft-d04 on 2016/11/16.
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] maxMap = new int[stones.length];
        map.put(0, new HashSet<>());
        map.get(0).add(0);
        int max = 0;
        for (int i = 1; i < stones.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i - 1; j >= 0; j--) {
                int step = stones[i] - stones[j];
                if (step > maxMap[j] + 1) break;
                if (map.get(j).contains(step - 1) || map.get(j).contains(step)
                        || map.get(j).contains(step + 1)) {
                    set.add(step);
                    max = Math.max(max, step);
                }
            }
            map.put(i, set);
            maxMap[i] = max;
        }
        return map.get(stones.length - 1).size() > 0;
    }
}
