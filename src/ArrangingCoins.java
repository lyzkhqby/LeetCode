/**
 * Created by zk on 2016/12/3.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int numRow = 0;
        while (n > numRow) {
            n -= ++numRow;
        }
        return numRow;
    }
}
