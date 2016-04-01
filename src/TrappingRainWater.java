/**
 * Created by rotoosoft-d04 on 2016/4/1.
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int sum = 0, level = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                level = Math.max(level, height[left]);
                sum += (level - height[left]);
                left++;
            }else {
                level = Math.max(level, height[right]);
                sum += (level - height[right]);
                right--;
            }
        }
        return sum;

    }
}
