/**
 * Created by zk on 2016/12/6.
 */
public class EliminationGame {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (n / 2 - lastRemaining(n / 2) + 1);
    }
}
