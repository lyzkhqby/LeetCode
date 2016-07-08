import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/7/8.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        if(strs == null || strs.length == 0) return res;

        int len = strs.length;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            String temp = sortStr(strs[i]);
            if(map.containsKey(temp)) {
                int index = map.get(temp);
                res.get(index).add(strs[i]);
            }else {
                map.put(temp, res.size());
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                res.add(list);
            }
        }
        return res;
    }

    private String sortStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
