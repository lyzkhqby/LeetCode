import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/4/20.
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<>();
        TreeNode t= new TreeNode(0);
        t.left = root;
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(t);
        helper(result, temp);
        return result;

    }

    private void helper(List<List<Integer>> result, List<TreeNode> temp) {
        if (temp.size() == 0) return;
        List<TreeNode> list = new ArrayList<>();
        for (TreeNode t : temp) {
            if (t.left != null) list.add(t.left);
            if (t.right != null) list.add(t.right);
        }
        if (list.size() != 0) {
            helper(result, list);
            List<Integer> vals = new ArrayList<>();
            for (TreeNode t : list) {
                vals.add(t.val);
            }
            result.add(vals);
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
