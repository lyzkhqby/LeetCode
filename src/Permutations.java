import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/10/26.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        helper(res, list, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
