import java.util.Arrays;

/**
 * Created by zk on 2016/6/17.
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Integer.min(min, nums[i]);
            max = Integer.max(max, nums[i]);
        }
        if(min == max) return 0;
        int bucketSize = (max - min) / (len - 1);
        if(bucketSize == 0) bucketSize = 1;
        int bucketCount = (max - min)/bucketSize + 1;
        int[] left = new int[bucketCount];
        int[] right = new int[bucketCount];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for (int i = 0; i < len; i++) {
            int pos = (nums[i] - min) / bucketSize;
            if(left[pos] == -1) {
                left[pos] = nums[i];
                right[pos] = nums[i];
            }else {
                left[pos] = Integer.min(left[pos], nums[i]);
                right[pos] = Integer.max(right[pos], nums[i]);
            }
        }

        int maxGap = Integer.MIN_VALUE, leftNumber = -1, rightNumber;
        for (int i = 0; i < bucketCount; i++) {
            if(left[i] != -1 && leftNumber == -1) {
                leftNumber = right[i];
            }else if(left[i] != -1 && leftNumber != -1) {
                rightNumber = left[i];
                maxGap = Integer.max(maxGap, rightNumber - leftNumber);
                leftNumber = right[i];
            }
        }
        return maxGap;

    }
}
