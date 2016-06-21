/**
 * Created by rotoosoft-d04 on 2016/6/21.
 */
public class ReverseString {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return "";
        char[] arrChar = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char temp = arrChar[left];
            arrChar[left] = arrChar[right];
            arrChar[right] = temp;
            left++;
            right--;
        }

        return new String(arrChar);
    }
}
