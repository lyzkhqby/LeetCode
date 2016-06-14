/**
 * Created by zk on 2016/6/14.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] countArray = new int[n + 1];

        for(int i = 0; i < n; i++) {
            if(citations[i] >= n) countArray[n]++;
            else countArray[citations[i]]++;
        }

        if(countArray[n] >= n) return n;
        for(int i = n - 1; i >= 0; i--) {
            countArray[i] = countArray[i] + countArray[i + 1];
            if(countArray[i] >= i) return i;
        }
        return 0;
    }
}
