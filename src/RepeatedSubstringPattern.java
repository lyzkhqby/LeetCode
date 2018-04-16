/**
 * Created by zk on 2016/12/3.
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String str) {
        int n = str.length(), cur = 0, j = 1;
        int[] pattern = new int[n];
        while (j < n) {
            if (str.charAt(cur) == str.charAt(j)) {
                pattern[j++] = ++cur; //注意是“循环”
            }else {
                if (cur == 0) pattern[j++] = 0;
                else cur = pattern[cur - 1]; /* start from beginning of current matching pattern */
            }
        }
        return (pattern[n - 1] > 0 && n % (n - pattern[n - 1]) == 0);
    }

    public static void main(String[] args) {
        String test = "abababbabababb";
        System.out.println(repeatedSubstringPattern(test));
    }
}

//测试用例[a, b, a, b, a, b, b, a, b, a, b, a, b, b]
