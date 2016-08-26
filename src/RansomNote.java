/**
 * Created by rotoosoft-d04 on 2016/8/26.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        int lenM = magazine.length(), lenR = ransomNote.length();
        for (int i = 0; i < lenM; i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < lenR; i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
