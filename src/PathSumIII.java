/**
 * Created by zk on 2016/10/31.
 */
public class PathSumIII {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root != null) {
            fun(root, sum);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }
        return count;
    }

    private void fun(TreeNode root, int sum) {
        if (root != null) {
            if (sum - root.val == 0) count++;
            fun(root.left, sum - root.val);
            fun(root.right, sum - root.val);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
