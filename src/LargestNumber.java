import java.util.Arrays;

/**
 * Created by rotoosoft-d04 on 2016/6/16.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] numStrs = new String[len];
        for (int i = 0; i < len; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));

        if(numStrs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrs) {
            sb.append(numStr);
        }
        return sb.toString();
    }
}
