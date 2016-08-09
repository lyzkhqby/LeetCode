/**
 * Created by rotoosoft-d04 on 2016/8/9.
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] minLast = new int[len];
        for (int i = 0; i < len; i++) {
            minLast[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < len; i++) {
            int index = binarySearch(minLast, nums[i]);
            minLast[index] = nums[i];
        }

        for (int i = len - 1; i >= 0; i--) {
            if(minLast[i] != Integer.MAX_VALUE) {
                return i + 1;
            }
        }

        return 0;

    }

    //找出第一个大于的
    private static int binarySearch(int[] minLast, int num) {
        int start = 0, end = minLast.length - 1;
        while(start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if(minLast[mid] < num) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if(minLast[start] >= num) return start;
        return end;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.print(lengthOfLIS(nums));
    }
}
