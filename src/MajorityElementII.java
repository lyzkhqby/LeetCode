import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为O(n)，空间复杂度为O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        int number1 = nums[0], number2 = nums[0];
        int count1 = 0, count2 = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1) {
                count1++;
            }else if (nums[i] == number2) {
                count2++;
            }else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            }else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1) count1++;
            else if (nums[i] == number2) count2++;
        }
        if (count1 > len / 3) result.add(number1);
        if (count2 > len / 3) result.add(number2);
        return result;
    }
}
