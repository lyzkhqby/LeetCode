/**
 * Created by rotoosoft-d04 on 2016/11/11.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

//a = 20, b = 30
//        二进制表示
//        a = 10100
//        b = 11110
//        不考虑进位的话
//        a = 10100
//        b = 11110
//        ----------
//        01010
//        需要进位的地方              10100
//        那么，理论上我们自己做加法还要加上进位的，这里需要把进位左移一位，然后继续做加法，直到没有进位
