/**
 * Created by rotoosoft-d04 on 2016/8/8.
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int low = 0;
        int high = n;
        int mid = low + ((high-low)>>1);
        int answer = guess(mid);
        while (answer != 0) {
            if(answer == -1) {
                high = mid - 1;
            }else if(answer == 1) {
                low = mid + 1;
            }
            mid = low + ((high-low)>>1);
            answer = guess(mid);
        }
        return mid;
    }

    //本题内置api
    private int guess(int num){
        return 0;
    }
}
