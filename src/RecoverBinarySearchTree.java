/**
 * Created by rotoosoft-d04 on 2016/5/13.
 */
public class RecoverBinarySearchTree {
    private TreeNode firstElement;
    private TreeNode secondElement;
    private TreeNode lastElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        helper(root);

        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);
        if (firstElement == null && root.val < lastElement.val) {
            firstElement = lastElement;
        }
        if (firstElement != null && root.val < lastElement.val) {
            secondElement = root;
        }
        lastElement = root;
        helper(root.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
