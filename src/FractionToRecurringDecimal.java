import java.util.HashMap;

/**
 * Created by rotoosoft-d04 on 2016/9/21.
 */
public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        result.append(sign);
        result.append(num / den);

        long remainder = num % den;
        if (remainder == 0) return result.toString();
        result.append(".");

        HashMap<Long, Integer> map = new HashMap<>();
        while (!map.containsKey(remainder)) {
            map.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        int index = map.get(remainder);
        result.insert(index, "(");
        result.append(")");


        return result.toString().replace("(0)", "");
    }

    public static void main(String[] args) {
        System.out.print(fractionToDecimal(1, 5));
    }
}
