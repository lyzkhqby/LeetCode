import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/4/19.
 */
public class BinaryTreeLevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        List<Integer> numOfRoot = new ArrayList<>();
        numOfRoot.add(root.val);
        result.add(numOfRoot);
        helper(result, temp);
        return result;
    }

    private void helper(List<List<Integer>> result, List<TreeNode> temp) {
        if (temp.size() == 0) return;
        List<TreeNode> list = new ArrayList<>();
        int len = temp.size();
        for (int i = 0; i < len; i++) {
            TreeNode t = temp.get(i);
            if (t.left != null) list.add(t.left);
            if (t.right != null) list.add(t.right);
        }
        List<Integer> vals = new ArrayList<>();
        if (list.size() != 0) {
            for (TreeNode treeNode : list) {
                vals.add(treeNode.val);
            }
            result.add(vals);
        }

        helper(result, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
