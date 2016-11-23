/**
 * Created by rotoosoft-d04 on 2016/11/23.
 */
public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & n - 1;
        }
        return n;
    }
}
