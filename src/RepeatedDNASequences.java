import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rotoosoft-d04 on 2016/9/19.
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        int len = s.length();
        for (int i = 0; i < len - 9; i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten)) {
                repeated.add(ten);
            }
        }
        return new ArrayList(repeated);
    }
}
