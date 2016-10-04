/**
 * Created by zk on 2016/10/4.
 */
public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        return x + y == z || (x + y > z) && z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
