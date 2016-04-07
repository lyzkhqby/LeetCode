/**
 * Created by rotoosoft-d04 on 2016/4/5.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        int rev = 0, temp = x;
        while (temp != 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }

        if(rev == x) return true;
        return false;
    }
}
