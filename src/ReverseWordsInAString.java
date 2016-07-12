/**
 * Created by zk on 2016/7/13.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i > 0; i--) {
            if(words[i].isEmpty()) continue;
            else {
                sb.append(words[i]);
                sb.append(" ");
            }
        }
        sb.append(words[0]);
        return sb.toString();
    }
}
