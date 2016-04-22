/**
 * Created by rotoosoft-d04 on 2016/4/22.
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) return lowestCommonAncestor(root, q, p);
        if (root.val >= p.val && root.val <= p.val) {
            return root;
        }
        return lowestCommonAncestor(
                p.val > root.val ? root.right : root.left,
                p, q);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
