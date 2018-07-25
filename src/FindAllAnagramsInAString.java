import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/10/31.
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()){
            return res;
        }
        int sLen = s.length(), pLen = p.length();

        int[] letters = new int[256];
        for (char c : p.toCharArray()) {
            letters[c - 'a']++;
        }

        int start = 0, end = 0, count = 0;
        while (end < sLen) {
            if (end - start == pLen && letters[s.charAt(start++) - 'a']++ >= 0) {
                count--;
            }
            if (--letters[s.charAt(end++) - 'a'] >= 0) {
                count++;
            }
            if (count == pLen) res.add(start);
        }
        return res;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }
}
