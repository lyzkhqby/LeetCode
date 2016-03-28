/**
 * Created by rotoosoft-d04 on 2016/3/28.
 */
public class MedianOfTwoSortedArrays {public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int len1 = nums1.length, len2 = nums2.length;
    int sumLen = len1 + len2;
    int mid = 0;
    if (sumLen % 2 == 0) {
        mid = sumLen / 2;
        return (helper (nums1, 0, len1, nums2, 0, len2, mid) + helper (nums1, 0, len1, nums2, 0, len2, mid + 1)) / 2.0 ;
    }else {
        mid = (sumLen) / 2 + 1;
        return helper (nums1, 0, len1, nums2, 0, len2, mid);
    }

}

    public int helper(int[] nums1, int start1, int len1, int[] nums2, int start2, int len2, int k) {
        int result = 0;
        if (len1 > len2) {
            result = helper(nums2, start2, len2, nums1, start1, len1, k);
            return result;
        }
        if (len1 == 0) {
            result = nums2[start2 + k - 1];
            return result;
        }
        if (k == 1) {

            result = Math.min(nums1[start1], nums2[start2]);
            return result;
        }

        int pnum1 = Math.min(k/2, len1), pnum2 = k - pnum1;
        if (nums1[start1 + pnum1 - 1] > nums2[start2 + pnum2 - 1]) {
            result = helper(nums1, start1, len1, nums2, start2 + pnum2, len2 - pnum2, k - pnum2);
        }else if (nums1[start1 + pnum1 - 1] < nums2[start2 + pnum2 - 1]) {
            result = helper(nums1, start1 + pnum1, len1 - pnum1, nums2, start2, len2, k-pnum1);
        }else {
            result = nums1[start1 + pnum1 - 1];
        }
        return result;
    }
}
