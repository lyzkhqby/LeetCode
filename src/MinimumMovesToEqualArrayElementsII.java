import java.util.Arrays;

/**
 * Created by rotoosoft-d04 on 2016/12/6.
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int res = 0;
        while (i < j) {
            res += nums[j] - nums[i];
            i++;
            j--;
        }
        return res;
    }
}
