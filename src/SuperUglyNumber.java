/**
 * Created by zk on 2016/4/12.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        int lenOfPrimes = primes.length;
        int[] pointers = new int[lenOfPrimes];
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < lenOfPrimes; j++) {
                int value = uglyNumbers[pointers[j]] * primes[j];
                if (value < min) {
                    min = value;
                    minIndex = j;
                }else if(value == min) {
                    pointers[j]++;
                }
            }
            uglyNumbers[i] = min;
            pointers[minIndex]++;
        }
        return uglyNumbers[n-1];
    }
}
