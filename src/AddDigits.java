/**
 * Created by zk on 2016/9/29.
 */
public class AddDigits {
    public int addDigits(int num) {
        return (num == 0 ? 0 : (num % 9 == 0 ? 9 : num % 9));
    }
}