import java.util.Arrays;

/**
 * Created by rotoosoft-d04 on 2016/11/22.
 */
public class Candy {
    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) return 0;
        int[] counts = new int[ratings.length];
        Arrays.fill(counts, 1);
        int sum = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                counts[i] = counts[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 1; i >= 1; i--) {
            sum += counts[i];
            if (ratings[i] < ratings[i - 1] && counts[i - 1] <= counts[i]) {
                counts[i - 1] = counts[i] + 1;
            }
        }
        sum += counts[0];
        return sum;
    }
}
