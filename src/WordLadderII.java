import java.util.*;

/**
 * Created by rotoosoft-d04 on 2016/8/4.
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        wordList.add(beginWord);
        wordList.add(endWord);

        bfs(map, distance, beginWord, endWord, wordList);
        List<String> path = new ArrayList<>();
        dfs(ladders, path, endWord, beginWord, distance, map);
        return ladders;

    }

    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }

        while(!q.isEmpty()) {
            String crt = q.poll();

            List<String> nextList = expand(crt, dict);
            for (String next : nextList) {
                map.get(next).add(crt);
                if(!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    q.offer(next);
                }
            }
        }
    }

    private List<String> expand(String crt, Set<String> dict) {
        List<String> res = new ArrayList<>();
        int len = crt.length();
        for (int i = 0; i < len; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if(ch != crt.charAt(i)) {
                    String expand = crt.substring(0, i) + ch + crt.substring(i + 1);
                    if(dict.contains(expand)) {
                        res.add(expand);
                    }
                }
            }
        }
        return res;
    }

    private void dfs(List<List<String>> ladders, List<String> path, String crt, String start,
                     Map<String, Integer> distance, Map<String, List<String>> map) {
        path.add(crt);

        if(crt.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        }else {
            for (String s : map.get(crt)) {
                if (distance.get(crt) == distance.get(s) + 1) {
                    dfs(ladders, path, s, start, distance, map);
                }
            }
        }

        path.remove(path.size() - 1);
    }
}
