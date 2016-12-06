/**
 * Created by rotoosoft-d04 on 2016/12/6.
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) count++;
        }
        return count;
    }
}
