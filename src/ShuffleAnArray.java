/**
 * Created by rotoosoft-d04 on 2016/11/2.
 */
public class ShuffleAnArray {
    private int[] nums;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = nums.length;
        int[] rand = new int[len];
        for (int i = 0 ; i < len; i++) {
            int r = (int) (Math.random() * (i + 1));
            rand[i] = rand[r];
            rand[r] = nums[i];
        }
        return rand;
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
}
