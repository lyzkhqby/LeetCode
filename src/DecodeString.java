import java.util.Stack;

/**
 * Created by rotoosoft-d04 on 2016/9/9.
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();

        int len = s.length();
        result.push("");

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            }else if (c == '[') {
                result.push("");
            }else if (c == ']') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();

                for (int j = 0; j < times; j++) {
                    sb.append(str);
                }

                result.push(result.pop() + sb.toString());
            }else {
                result.push(result.pop() + c);
            }
        }

        return result.pop();
    }
}
