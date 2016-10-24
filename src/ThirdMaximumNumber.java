/**
 * Created by rotoosoft-d04 on 2016/10/24.
 */
public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE, second = max, third = max;
        boolean flag = false;

        for (int num : nums) {
            if (num == Integer.MIN_VALUE) flag = true;
            else if (num == max || num == second || num == third) continue;
            else if (num > max) {
                third = second;
                second = max;
                max = num;
            }else if (num > second) {
                third = second;
                second = num;
            }else if (num > third) {
                third = num;
            }
        }
        //第三个冒号对应{1,-2147483648,2}情况
        //第二个冒号对应{-2147483648,1,1}情况
        return (third != Integer.MIN_VALUE) ? third : (second == Integer.MIN_VALUE) ? max : (flag == true) ? third : max;
    }

}
