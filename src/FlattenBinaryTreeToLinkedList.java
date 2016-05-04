/**
 * Created by rotoosoft-d04 on 2016/5/4.
 */
public class FlattenBinaryTreeToLinkedList {
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        if (root == null) return;

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
