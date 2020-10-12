package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null && nums.length == 0) return results;
        helper(new ArrayList<>(), nums, 0, results);
        return results;
    }

    private void helper(ArrayList<Integer> subset, int[] nums, int startIndex, List<List<Integer>> results) {
        results.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(subset, nums, i + 1, results);
            subset.remove(subset.size() - 1);
        }
    }
}
