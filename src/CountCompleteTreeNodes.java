/**
 * Created by rotoosoft-d04 on 2016/4/29.
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getLeft(root);
        int right = getRight(root);
        if (left == right) return (2<<(left - 1)) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int getLeft(TreeNode t) {
        int result = 0;
        while (t != null) {
            result++;
            t = t.left;
        }
        return result;

    }

    private int getRight(TreeNode t) {
        int result = 0;
        while (t != null) {
            result++;
            t = t.right;
        }
        return result;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
