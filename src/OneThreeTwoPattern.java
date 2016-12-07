import java.util.Stack;

/**
 * Created by rotoosoft-d04 on 2016/12/7.
 */
public class OneThreeTwoPattern {
    class Pair {
        int min, max;
        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        for (int n : nums) {
            if (stack.isEmpty() || n < stack.peek().min) stack.push(new Pair(n, n));
            else if (n > stack.peek().min) {
                Pair last = stack.pop();
                if (n < last.max) return true;
                else {
                    last.max = n;
                    while (!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    if (!stack.isEmpty() && n > stack.peek().min) return true;
                    stack.push(last);
                }
            }
        }
        return false;


    }
}
//{6, 1, 4, 5}