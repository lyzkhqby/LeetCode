/**
 * Created by zk on 2016/10/23.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int sum = 0, carry = 0;
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1,
                j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) sum = num1.charAt(i) + num2.charAt(j) - 96 + carry;
            else if (i >= 0) sum = num1.charAt(i) - 48 + carry;
            else if (j >= 0) sum = num2.charAt(j) - 48 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (carry == 1) sb.append("1");
        return sb.reverse().toString();
    }
}
