/**
 * Created by rotoosoft-d04 on 2016/11/23.
 */
public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            reverse = (reverse << 1) | (n & 1);
            n = (n >> 1);
        }
        return reverse;

    }
}
