/**
 * Created by zk on 2016/12/7.
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int idx = 0;
        while (idx < data.length) {
            int utfIdx = idx++;
            if ((data[utfIdx] & (1 << 7)) == 0) continue; //single byte
            for (int i = 6; i >= 0; i--) {
                if ((data[utfIdx] & (1 << i)) > 0) { //find one more byte in multiple bytes
                    if (idx >= data.length) return false; //not enough bytes
                    if (((data[idx] & (1 << 7)) == 0) || ((data[idx] & (1 << 6)) > 0)) return false; //not starting with 10xxxxxx
                    idx++;
                } else if (i == 6) return false; //for fist byte in multiple bytes is 10xxxxxx, at least 110xxxxx
                else break; //meet 0, remaining as utf content
            }
        }
        return true;
    }
}
