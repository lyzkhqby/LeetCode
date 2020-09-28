package dynamicprogramming;

/**
 * Created by rotoosoft-d04 on 2016/11/1.
 给定一个整数数组nums，求出数组从索引i到j(i≤j) 范围内元素的总和，包含i, j两点。

 示例：

 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()

 sumRange(0, 2) -> 1
 sumRange(2, 5) -> -1
 sumRange(0, 5) -> -3
 说明:

 你可以假设数组不可变。
 会多次调用sumRange方法。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeSumQueryImmutable {
    private int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        int len = nums.length;
        sum = new int[nums.length + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }

    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
