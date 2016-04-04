/**
 * Created by zk on 2016/4/4.
 */
public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        return getLargestArea(heights, 0, heights.length);
    }

    private int getLargestArea(int[] heights, int start, int end) {
        if (start + 1 >= end) return heights[start];
        int min = start;
        boolean aesc = true;
        for (int i = start; i < end; i++) {
            if (i > start && heights[i - 1] > heights[i]) aesc = false;
            if (heights[min] > heights[i]) min = i;
        }
        if (aesc) {
            int max = 0;
            for (int i = start; i < end; i++) {
                max = Math.max(heights[i] * (end - i), max);
            }
            return max;
        }
        int LMax = (min > start) ? getLargestArea(heights, start, min) : 0;
        int RMax = (min < end - 1) ? getLargestArea(heights, min + 1, end) : 0;
        return Math.max(Math.max(LMax, RMax), heights[min] * (end - start));
    }
}
