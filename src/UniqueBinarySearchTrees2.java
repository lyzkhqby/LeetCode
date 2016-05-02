import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/5/3.
 */
public class UniqueBinarySearchTrees2 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);
            for (int j =0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(j);
                    root.right = right.get(k);
                    list.add(root);
                }
            }
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
