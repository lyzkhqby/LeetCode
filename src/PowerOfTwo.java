/**
 * Created by rotoosoft-d04 on 2016/11/11.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

//如果一个数是2的次方数的话，根据上面分析，那么它的二进数必然是最高位为1，
// 其它都为0，那么如果此时我们减1的话，则最高位会降一位，
// 其余为0的位现在都为变为1，那么我们把两数相与，就会得到0
