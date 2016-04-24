import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/4/24.
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        helper(root, k, list);
        result = list.get(k - 1);
        return result;
    }

    private void helper(TreeNode root, int k, List<Integer> list) {
        if (root == null) return;
        helper(root.left, k, list);
        list.add(root.val);
        if (list.size() == k) return;
        helper(root.right, k, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
