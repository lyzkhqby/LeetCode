import java.util.Stack;

/**
 * Created by rotoosoft-d04 on 2016/4/26.
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> s = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        while (root != null) {
            s.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = s.pop();
        TreeNode temp = result.right;
        while (temp != null) {
            s.push(temp);
            temp = temp.left;
        }
        return result.val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
