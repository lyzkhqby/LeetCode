import java.util.Arrays;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/12/2.
 */
public class CountOfSmallerNumbersAfterSelf {
    static class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s) {
            val = v;
            sum = s;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }

    private static Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        }else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        }else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        }else {
            node.right = insert(num, node.right, ans, i, preSum + node.sum + node.dup);
        }
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 6, 1};
        countSmaller(nums);
    }
}
