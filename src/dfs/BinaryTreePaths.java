package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/4/18.
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
