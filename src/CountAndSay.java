/**
 * Created by rotoosoft-d04 on 2016/6/22.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            char temp = res.charAt(0);
            for (int j = 0; j < res.length();) {
                while(j < res.length() && temp == res.charAt(j)) {
                    count++;
                    j++;
                }
                sb.append(String.valueOf(count));
                sb.append(temp);
                count = 0;
                if(j < res.length()) temp = res.charAt(j);
            }
            res = sb.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(countAndSay(5));
    }
}
