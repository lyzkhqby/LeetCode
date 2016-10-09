/**
 * Created by rotoosoft-d04 on 2016/10/9.
 */
public class NumberOfDigitOne {
    /**
     * Calculate occurance on every digit, from
     * least important digit to most important digit
     * number = 1432
     * One's digit: n/10=143 143*1+1
     * Ten's digit: n/100=14 14*10+10
     * Hun's digit: n/1000=1 1*100+100
     * Tho's digit: 1432%1000+1=433
     * Sum all occurance on digits together
     */
    public int countDigitOne(int n) {
        int factor = 1, count = 0, k = n;
        while (n > 0) {
            int m = n / 10,
                    r = n % 10,
                    amount = 0;
            if (r == 0) amount = 0;
            else if (r > 1) amount = factor;
            else amount = k % factor + 1;

            count += m * factor + amount;
            factor *= 10;
            n /= 10;
        }
        return count;
    }
}
