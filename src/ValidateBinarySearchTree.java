/**
 * Created by rotoosoft-d04 on 2016/5/10.
 */
public class ValidateBinarySearchTree {
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;
        if (prev != null && root.val <= prev.val) return false;
        prev = root;
        return isValidBST(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
}
