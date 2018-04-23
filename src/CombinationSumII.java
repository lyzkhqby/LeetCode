import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) return result;
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, combination, result);
        return result;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i != index && candidates[i] == candidates[i - 1]) continue;
            combination.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }

}
