import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/5/5.
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null) {
            List<Integer> list = new ArrayList<>();
            helper(root, list, lists, sum);
        }

        return lists;
    }

    private void helper(TreeNode root, List<Integer> list, List<List<Integer>> lists, int sum) {
        List<Integer> temp = new ArrayList<>();
        temp.addAll(list);
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum  == root.val) {
                lists.add(temp);
            }
            return;

        }


        TreeNode right = root.right;
        if (root.left != null) {
            helper(root.left, temp, lists, sum - root.val);
        }
        if(right != null) {
            helper(right, temp, lists, sum - root.val);
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
