import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zk on 2016/10/26.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int len = nums.length;
        Arrays.sort(nums);
        int[] visited = new int[len];
        List<Integer> list = new ArrayList<>();
        helper(res, visited, list, nums);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] visited, List<Integer> list, int[] nums) {
        int len = nums.length;
        if (list.size() == len) {
            res.add(new ArrayList<Integer>(list));
            return;

        }

        for (int i = 0; i < len; i++) {
            if (visited[i] == 1 || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) continue;

            visited[i] = 1;
            list.add(nums[i]);
            helper(res, visited, list, nums);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }

    
}
