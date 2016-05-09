/**
 * Created by rotoosoft-d04 on 2016/5/9.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null && inorder.length == 0) return null;
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (pstart > pend) return null;

        if (pstart == pend) return new TreeNode(postorder[pstart]);

        TreeNode root  = new TreeNode(postorder[pend]);
        int idex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[pend]) {
                idex = i;
                break;
            }
        }

        root.left = helper(inorder, istart, idex - 1, postorder, pstart, pstart + idex - istart - 1);
        root.right = helper(inorder, idex + 1, iend, postorder, pstart + idex - istart, pend - 1);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
