/**
 * Created by zk on 2016/6/9.
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while(l < r) {
            int mid = l + (l - r)/2;
            if(isBadVersion(mid)) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;

    }

    boolean isBadVersion(int version){
        return true;
    }
}
