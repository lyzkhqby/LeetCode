import java.util.Stack;

/**
 * Created by zk on 2016/9/10.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int len = tokens.length;

        for (int i = 0; i < len; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*")|| token.equals("/")) {
                cal(s, token);
            }else {
                s.push(Integer.parseInt(token));
            }

        }
        return s.pop();
    }

    private void cal(Stack<Integer> s, String op) {
        if (s.empty()) return;
        int i2 = s.pop();
        if (s.empty()) return;
        int i1 = s.pop();
        switch (op) {
            case "+":
                s.push(i1 + i2);
                break;
            case "-":
                s.push(i1 - i2);
                break;
            case "*":
                s.push(i1 * i2);
                break;
            case "/":
                s.push(i1 / i2);
                break;
        }

    }
}
