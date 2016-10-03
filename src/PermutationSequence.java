import java.util.LinkedList;
import java.util.List;

/**
 * Created by zk on 2016/10/3.
 */
public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i; // factorial
        }

        StringBuilder strBuilder = new StringBuilder();
        for (k--; n > 0; n--) {
            fact /= n;
            strBuilder.append(list.remove(k / fact));
            k %= fact;
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.print(getPermutation(3, 6));
    }
}
