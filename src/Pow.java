/**
 * Created by rotoosoft-d04 on 2016/8/8.
 */
public class Pow {

    public static double myPow(double x, int n) {
        if (n == 0) return 1.0;
        double half = myPow(x, n/2);
        if (n % 2 == 0)  {
            return half * half;
        }
        else if (n>0)  {
            return half * half * x;
        }
        else {
            return half / x * half;
        }
    }

    public static void main(String[] args) {
        myPow(2.00000, -2);
    }
}
