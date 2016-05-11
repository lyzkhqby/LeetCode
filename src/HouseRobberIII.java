/**
 * Created by rotoosoft-d04 on 2016/5/11.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode root) {
        int[] dp = {0, 0};
        if (root != null) {
            int[] dp_L = dfs(root.left);
            int[] dp_R = dfs(root.right);
            dp[1] = dp_L[0] + dp_R[0];
            dp[0] = Math.max(dp[1], dp_L[1] + dp_R[1] + root.val);
        }
        return dp;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
