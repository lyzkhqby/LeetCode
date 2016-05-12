import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rotoosoft-d04 on 2016/5/12.
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        TreeNode prev = null;
        while(!s.empty()) {
            while (root.left != null) {
                root = root.left;
                s.push(root);
            }
            TreeNode t = s.peek();
            if (t.right == null) {
                res.add(t.val);
                prev = s.peek();
                s.pop();
            }else if(t.right == prev) {
                res.add(t.val);
                prev = s.peek();
                s.pop();
            }else {
                root = t.right;
                s.push(root);
            }
        }
        return res;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
