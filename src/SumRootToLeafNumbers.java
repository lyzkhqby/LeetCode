/**
 * Created by rotoosoft-d04 on 2016/4/27.
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        if (root != null) {
            sum = helper(root, 0);
        }
        return sum;
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return sum * 10 + root.val;
        return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
