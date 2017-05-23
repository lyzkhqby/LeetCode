import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zk on 2016/5/1.
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (root.left != null) {
            stack.push(root.left);
            root = root.left;
        }

        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            result.add(temp.val);
            TreeNode treeNode = temp.right;
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
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
