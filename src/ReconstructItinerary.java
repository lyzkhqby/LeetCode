import java.util.*;

/**
 * Created by zk on 2016/10/24.
 */
public class ReconstructItinerary {
    public static List<String> findItinerary(String[][] tickets) {
        List<String> list = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        int len = tickets.length;
        String cur = "JFK";
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(tickets[i][0])) {
                map.put(tickets[i][0], new PriorityQueue<String>());
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        dfs(map, cur, list);
        Collections.reverse(list);
        return list;
    }

    private static void dfs(HashMap<String, PriorityQueue<String>> map, String cur, List<String> list) {
        while (map.containsKey(cur) && !map.get(cur).isEmpty()) {
            dfs(map, map.get(cur).poll(), list);
        }
        list.add(cur);
    }
    public static void main(String[] args) {
        String[][] tickets = {{"JFK","SFO"}, {"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"}};
        findItinerary(tickets);
    }
}
