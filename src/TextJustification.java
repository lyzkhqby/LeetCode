import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/8/7.
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if(words == null || words.length == 0 || maxWidth == 0) {
            result.add("");
            return result;
        }
        int lenOfWords = words.length;

        int count = -1;
        int lastSeen = -1;

        int j = 0;
        while(j < lenOfWords) {
            int len = words[j].length() + 1;
            if(count + len > maxWidth) {
                result.add(construct(words, lastSeen + 1, j - 1, count, maxWidth));
                count = -1;
                lastSeen = j - 1;
            }
            count += len;
            j++;
        }

        //最后一行
        StringBuilder sb = new StringBuilder();
        for(int i = lastSeen + 1; i < j; i++) {
            if(i != lastSeen + 1) {
                sb.append(" ");
            }
            sb.append(words[i]);
        }
        for (int i = 0; i < maxWidth - count; i++) sb.append(" ");
        result.add(sb.toString());
        return result;
    }

    private String construct(String[] words, int start, int end, int count, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if(start == end) {
            sb.append(words[start]);
            int size = sb.length();
            for (int i = 0; i < maxWidth - size; i++) sb.append(" ");
        }else {
            int evenSpace = (maxWidth - count) / (end - start);
            int nonEvenSpace = (maxWidth - count) % (end - start);
            for (int i = start; i <= end; i++) {
                if(i != start) {
                    sb.append(" ");
                    for (int j = 0; j < evenSpace; j++) sb.append(" ");
                    if(nonEvenSpace > 0) {
                        sb.append(" ");
                        nonEvenSpace--;
                    }
                }
                sb.append(words[i]);
            }

        }
        return sb.toString();
    }
}
