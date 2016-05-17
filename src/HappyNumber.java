import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/5/17.
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int temp = n;
        List<Integer> list = new ArrayList<>();
        while(!isExist(temp, list) && temp != 1) {
            temp = cal(temp);
        }
        if(temp == 1) {
            return true;
        }
        return false;
    }


    private boolean isExist(int temp, List<Integer> list) {

        for (Integer item : list) {
            if (item == temp) {
                return true;
            }
        }
        list.add(temp);
        return false;
    }

    private int cal(int n) {
        int res = 0;
        while (n != 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
