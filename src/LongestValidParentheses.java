import java.util.Stack;

/**
 * Created by rotoosoft-d04 on 2016/8/2.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0 || !s.contains(")")) return 0;
        int maxLen = 0, last = -1;
        int len = s.length();

        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else {
                if(stack.isEmpty()) {
                    last = i;
                }else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - last);
                    }else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }

        return maxLen;

    }


}
