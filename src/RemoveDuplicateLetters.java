import java.util.Stack;

/**
 * Created by zk on 2016/9/10.
 */
public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            count[cur - 'a']--;
            if (stack.contains(cur)) continue;
            while (!stack.empty() && cur < stack.peek() && count[stack.peek() - 'a'] > 0) {
                stack.pop();
            }
            stack.push(cur);
        }
        String res = "";
        while (!stack.empty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(removeDuplicateLetters("bcabc"));
    }
}
