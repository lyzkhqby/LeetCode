/**
 * Created by rotoosoft-d04 on 2016/6/24.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int count = 0;
        boolean isEnd = true;
        for (int i = len - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                count++;
                isEnd = false;
            }else if(!isEnd){
                break;
            }
        }
        return count;
    }
}
