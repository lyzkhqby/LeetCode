/**
 * Created by rotoosoft-d04 on 2016/6/23.
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s == null || s.length() < 2) return true;

        int len = s.length();
        int left = 0, right = len - 1;
        while (left < right) {
            while(left < len && !isAlphanumeric(s.charAt(left))) left++;
            while(right >= 0 && !isAlphanumeric(s.charAt(right))) right--;

            if(left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static boolean isAlphanumeric(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }

    public static void main(String[] args){
        System.out.print(isPalindrome("ab"));
    }
}
