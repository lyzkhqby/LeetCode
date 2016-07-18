import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/7/18.
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0)
            return res;
        HashMap<String, Integer> map = new HashMap<>();
        int sLen = s.length();
        int wordsLen = words.length;
        int wLen = words[0].length();
        for(int i = 0; i < wordsLen; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], 1);
            }else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }



        for (int i = 0; i < wLen; i++) {
            HashMap<String, Integer> curMap = new HashMap<>();
            int count = 0, left = i;
            for (int j = i; j <= sLen - wLen; j+= wLen) {
                String curStr = s.substring(j, j + wLen);
                if(map.containsKey(curStr)) {
                    if(curMap.containsKey(curStr)) {
                        curMap.put(curStr, curMap.get(curStr) + 1);
                    }else {
                        curMap.put(curStr, 1);
                    }
                    if(curMap.get(curStr) <= map.get(curStr)) {
                        count++;
                    }else {
                        while(true) {
                            String temp = s.substring(left, left + wLen);
                            curMap.put(temp, curMap.get(temp) - 1);
                            left += wLen;
                            if(temp.equals(curStr)) {
                                break;
                            }else {
                                count--;
                            }
                        }
                    }
                    if(count == wordsLen) {
                        res.add(left);
                        String temp = s.substring(left, left + wLen);
                        curMap.put(temp, curMap.get(temp) - 1);
                        left += wLen;
                        count--;
                    }
                }else {
                    curMap.clear();
                    count = 0;
                    left = j + wLen;
                }

            }
        }
        return res;
    }
}
