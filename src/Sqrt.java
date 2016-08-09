/**
 * Created by rotoosoft-d04 on 2016/8/9.
 */
public class Sqrt {
    public int mySqrt(int x) {
        long start = 0, end = x;
        while(start + 1 < end) {
            long mid = (start + end) / 2;
            if(mid * mid <= x) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if(end * end <= x) return (int)end;
        return (int)start;
    }
}
