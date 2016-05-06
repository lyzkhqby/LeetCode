import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rotoosoft-d04 on 2016/5/6.
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> sOdd = new Stack<>();
        Stack<TreeNode> sEven = new Stack<>();
        sOdd.push(root);
        while (!sOdd.empty() || !sEven.empty()) {
            if (!sEven.empty()) {
                List<Integer> temp2 = new ArrayList<>();
                while (!sEven.empty()) {
                    TreeNode t2 = sEven.pop();
                    if (t2.right != null) sOdd.push(t2.right);
                    if (t2.left != null) sOdd.push(t2.left);
                    temp2.add(t2.val);
                }
                res.add(temp2);
            }
            if (!sOdd.empty()) {
                List<Integer> temp1 = new ArrayList<>();
                while (!sOdd.empty()) {
                    TreeNode t1 = sOdd.pop();
                    if (t1.left != null) sEven.push(t1.left);
                    if (t1.right != null) sEven.push(t1.right);
                    temp1.add(t1.val);
                }
                res.add(temp1);
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
