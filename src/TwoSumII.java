/**
 * Created by zk on 2016/8/18.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {

        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int total = numbers[low] + numbers[high];
            if (total < target) {
                low++;
            }else if (total > target) {
                high--;
            }else {
                int[] res = {low + 1, high + 1};
                return res;
            }
        }
        return null;
    }
}
