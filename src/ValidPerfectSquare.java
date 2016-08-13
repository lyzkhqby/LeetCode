/**
 * Created by zk on 2016/8/13.
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(mid == num / mid) {
                return num % mid == 0;
            }else if (mid < num / mid) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return false;
    }

}
