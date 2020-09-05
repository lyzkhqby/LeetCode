package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/6/8.
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * 说明：
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;
        int index = 0;
        while(i < len1 && j < len2) {
            if(nums1[i] == nums2[j]) {
                if(index == 0 || res.get(index - 1) != nums1[i]) {
                    res.add(nums1[i]);
                    index++;
                }
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
