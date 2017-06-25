/**
 * Created by rotoosoft-d04 on 2016/11/1.
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
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
