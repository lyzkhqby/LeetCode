import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/4/18.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        helper(root, "", paths);
        return paths;

    }

    private void helper(TreeNode root, String path, List<String> paths) {
        path = path + Integer.toString(root.val);

        if (root.left == null && root.right == null) {
            paths.add(path);
        }

        path = path + "->";
        if (root.left != null) {
            helper(root.left, path, paths);
        }
        if (root.right != null) {
            helper(root.right, path, paths);
        }

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
