/**
 * Created by rotoosoft-d04 on 2016/6/7.
 */
public class BinaryTreeMaximumPathSum {
    public class Solution {
        public int maxPathSum(TreeNode root) {
            if(root == null) return 0;
            int[] res =  {Integer.MIN_VALUE};
            helper(root, res);
            return res[0];
        }

        private int helper(TreeNode root, int[] res) {
            if(root == null) return 0;
            int left = helper(root.left, res);
            int right = helper(root.right, res);
            int cur = root.val + Math.max(left, 0) + Math.max(right, 0);
            if(cur > res[0]) {
                res[0] = cur;
            }
            return root.val + Math.max(left, Math.max(right, 0));
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
