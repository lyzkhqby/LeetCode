import java.util.*;

/**
 * Created by zk on 2016/8/28.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<Map.Entry<Integer, Integer>> (new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
                        return entry2.getValue() - entry1.getValue();
                    }
                });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            list.add(entry.getKey());
        }

        return list;
    }
}
