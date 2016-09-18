/**
 * Created by rotoosoft-d04 on 2016/9/18.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int cows = 0;
        int bulls = 0;
        int[] secret_bucket = new int[10];
        int[] guess_bucket = new int[10];
        int len = secret.length();

        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                secret_bucket[secret.charAt(i) - '0']++;
                guess_bucket[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (secret_bucket[i] > 0 && guess_bucket[i] > 0) {
                cows += Math.min(secret_bucket[i], guess_bucket[i]);
            }
        }

        return bulls + "A" + cows + "B";
    }
}
