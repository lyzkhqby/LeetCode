import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/4/24.
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, 1);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list, int k) {
        if (root == null) return;
        if (list.size() < k) {
            list.add(root.val);
        }
        helper(root.right, list, k + 1);
        helper(root.left, list, k + 1);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
