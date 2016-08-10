/**
 * Created by rotoosoft-d04 on 2016/8/10.
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        int len = citations.length;
        int start = 0, end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(citations[mid] < len - mid) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return len - start;
    }
}
