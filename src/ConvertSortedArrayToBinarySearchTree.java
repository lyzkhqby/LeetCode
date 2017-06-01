/**
 * Created by zk on 2016/5/1.
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class ConvertSortedArrayToBinarySearchTree {


     public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     }

    public class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int start, int end) {
            TreeNode t = null;
            if (end - start > 1) {
                int mid = (start + end) / 2;
                t = new TreeNode(nums[mid]);
                t.left = helper(nums, start, mid - 1);
                t.right = helper(nums, mid + 1, end);
            }else if (end - start == 1) {
                t = new TreeNode(nums[start]);
                t.right = new TreeNode(nums[end]);

            }else if (end == start) {
                t = new TreeNode(nums[start]);
            }
            return t;
        }
    }
}
