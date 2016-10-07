/**
 * Created by zk on 2016/10/7.
 */
public class SuperPow {
    public int superPow(int a, int[] b) {
        int res = 1;
        int len = b.length;
        for (int i = 0; i < len; i++) {
            res = Pow(res, 10) * Pow(a, b[i]) % 1337;

        }
        return res;
    }

    private int Pow(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x % 1337;
        return Pow(x % 1337, n / 2) * Pow(x % 1337, n - n / 2) % 1337;
    }
}
