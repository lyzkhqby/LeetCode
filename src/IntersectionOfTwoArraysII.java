import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/6/8.
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;
        int index = 0;
        while(i < len1 && j < len2) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }
        }
        int len = res.size();
        int[] result = new int[len];
        for (int k = 0; k < len; k++) {
            result[k] = res.get(k);
        }
        return result;

    }
}
