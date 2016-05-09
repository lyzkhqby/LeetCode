/**
 * Created by rotoosoft-d04 on 2016/5/9.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null && preorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend) return null;
        if (pstart == pend) return new TreeNode(preorder[pstart]);

        TreeNode root = new TreeNode(preorder[pstart]);
        int idex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[pstart]) {
                idex = i;
                break;
            }
        }

        root.left = helper(preorder, pstart + 1, pstart + idex - istart, inorder, istart, idex - 1);
        root.right = helper(preorder, pstart + idex - istart + 1, pend, inorder, idex + 1, iend);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
