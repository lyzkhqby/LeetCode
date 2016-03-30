/**
 * Created by rotoosoft-d04 on 2016/3/30.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                int tleft = left;
                while (tleft < right && height[tleft] <= height[left]) {
                    tleft++;
                }
                left = tleft;
            } else {
                int tright = right;
                while (tright > left && height[tright] <= height[right]) {
                    tright--;
                }
                right = tright;
            }
        }
        return maxArea;
    }
}
