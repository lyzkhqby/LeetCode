import java.util.Arrays;
import java.util.Comparator;

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

        Arrays.sort(numStrs, new NumbersComparator());

        if(numStrs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrs) {
            sb.append(numStr);
        }
        return sb.toString();
    }

    class NumbersComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
}
