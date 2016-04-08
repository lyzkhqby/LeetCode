/**
 * Created by rotoosoft-d04 on 2016/4/8.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result = false;
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        if (root.left != null) {
            result = hasPathSum(root.left, sum - root.val);
        }
        if (root.right != null && result == false) {
            result = hasPathSum(root.right, sum - root.val);
        }
        return result;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
