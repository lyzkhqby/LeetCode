import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/7/4.
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) {
            return res;
        }
        helper(res, list, s, 0);
        return res;
    }

    private void helper(List<String> res, List<String> list, String s, int start) {
        if(list.size() == 4) {
            if(start != s.length()) return;
            StringBuffer sb = new StringBuffer();
            for (String tmp : list) {
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }

        for (int i = start; i < s.length() && i <= start + 3; i++) {
            String temp = s.substring(start, i + 1);
            if(isvalid(temp)) {
                list.add(temp);
                helper(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isvalid(String s) {
        if(s.charAt(0) == '0') return s.equals("0");
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}
