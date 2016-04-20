import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/4/20.
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
