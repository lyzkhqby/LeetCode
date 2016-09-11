import java.util.Stack;

/**
 * Created by zk on 2016/9/11.
 */
public class BasicCalculator {
    public int calculate(String s) {
        int len = s.length();
        int sign = 1, result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = c - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            }else if (c == '+') {
                sign = 1;
            }else if (c == '-') {
                sign = -1;
            }else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if (c == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }

        return result;
    }
}
