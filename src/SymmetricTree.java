import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rotoosoft-d04 on 2016/4/21.
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root, root);
//迭代方法
//        if (root == null) return true;
//        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
//        q1.add(root.left);
//        q2.add(root.right);
//        while (!q1.isEmpty() && !q2.isEmpty()) {
//            int len = q1.size();
//            for (int i = 0; i < len; i++) {
//                TreeNode cur1 = q1.remove(), cur2 = q2.remove();
//                if (cur1 == null && cur2 == null) continue;
//                if (cur1 == null || cur2 == null) return false;
//                if (cur1.val != cur2.val) return false;
//                q1.add(cur1.left);
//                q1.add(cur1.right);
//                q2.add(cur2.right);
//                q2.add(cur2.left);
//            }
//        }
//        return q1.isEmpty() && q2.isEmpty();
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val
                && isSymmetric(p.left, q.right)
                && isSymmetric(p.right, q.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
