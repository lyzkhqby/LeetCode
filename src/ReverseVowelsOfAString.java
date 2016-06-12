/**
 * Created by rotoosoft-d04 on 2016/6/12.
 */
public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return "";
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while(l < r) {
            if(isVowel(arr[l]) && isVowel(arr[r])) {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }else if(isVowel(arr[l])) {
                r--;
            }else if(isVowel(arr[r])) {
                l++;
            }else {
                l++;
                r--;
            }
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
