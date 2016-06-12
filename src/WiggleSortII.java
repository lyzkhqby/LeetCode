/**
 * Created by rotoosoft-d04 on 2016/6/12.
 */
public class WiggleSortII {

    public static void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int n = nums.length;
        int mid = findMedian(nums, 0, n - 1, (n - 1)/2);

        int[] temp = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if(nums[i] < nums[mid]) {
                temp[left] = nums[i];
                left++;
            }else if(nums[i] > nums[mid]) {
                temp[right] = nums[i];
                right--;
            }
        }

        for (int i = left; i <= right; i++) {
            temp[i] = nums[mid];
        }

        left = (n - 1) / 2;
        right = n - 1;

        for(int i = 0; i < n; i++) {
            if((i & 1) == 0) {
                nums[i] = temp[left];
                left--;
            }else {
                nums[i] = temp[right];
                right--;
            }
        }
    }

    private static int findMedian(int[] nums, int lo, int hi, int k) {

        int pivot = partition(nums, lo, hi);
        if(pivot == k) return pivot;

        if(pivot > k) {
            return findMedian(nums, lo, pivot - 1, k);
        }else {
            return findMedian(nums, pivot + 1, hi, k);
        }
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = hi;
        int l = lo - 1;
        int r = lo;
        while(r < hi) {
            if(nums[r] < nums[pivot]) {
                l++;
                swap(nums, l, r);
            }
            r++;
        }
        swap(nums, l + 1, pivot);
        return l + 1;

    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,2,2,3,3,1};
        WiggleSortII.wiggleSort(nums);
        for (int item :
                nums) {
            System.out.print(item + " ");
        }
    }
}
