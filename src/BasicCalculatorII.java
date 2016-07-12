import java.util.Stack;

/**
 * Created by zk on 2016/7/13.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        int len;
        if(s == null || (len = s.length()) == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char lastSign = '+';
        for (int i = 0; i < len; i++) {
            if(Character.isDigit(s.charAt(i))) num = num * 10 + s.charAt(i) - '0';
            if((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
                if(lastSign == '+') stack.push(num);
                if(lastSign == '-') stack.push(-num);
                if(lastSign == '*') stack.push(stack.pop() * num);
                if(lastSign == '/') stack.push(stack.pop() / num);
                lastSign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for (Integer i : stack) {
            res += i;
        }
        return res;
    }
}
