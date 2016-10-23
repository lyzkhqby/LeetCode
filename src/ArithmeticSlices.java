/**
 * Created by zk on 2016/10/23.
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int sum = 0, cur = 0;
        int len = A.length;
        for (int i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur++;
                sum += cur;
            }else {
                cur = 0;
            }
        }
        return sum;
    }
}
