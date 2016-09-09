import java.util.Stack;

/**
 * Created by rotoosoft-d04 on 2016/9/9.
 */
public class VerifyPreorderSerializationOfABinaryTree {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null) return false;

        Stack<String> stack = new Stack<>();
        String[] preorders = preorder.split(",");
        int len = preorders.length;

        for (int i = 0; i < len; i++) {
            String cur = preorders[i];
            while (cur.equals("#") && !stack.isEmpty() && stack.peek().equals(cur)) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(cur);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }
}
