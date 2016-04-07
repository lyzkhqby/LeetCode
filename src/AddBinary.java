import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/4/5.
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        int alen = a.length(), blen = b.length();
        int minLen = (alen < blen) ? alen : blen;
        int maxLen = (alen > blen) ? alen : blen;
        char[] chars = new char[maxLen + 1];
        int clen = chars.length;
        boolean addOne = false;
        for (int i = 1; i <= minLen; i++) {
            if (a.charAt(alen - i) == '1' && b.charAt(blen - i) == '1') {
                if (addOne) {
                    chars[clen - i] = '1';
                }else {
                    chars[clen - i] = '0';
                }
                addOne = true;
            }else if (a.charAt(alen - i) == '0' && b.charAt(blen - i) == '0') {
                if (addOne) {
                    chars[clen - i] = '1';
                }else {
                    chars[clen - i] = '0';
                }
                addOne = false;
            }else {
               if(addOne) {
                   chars[clen - i] = '0';
                   addOne = true;
               }else {
                   chars[clen - i] = '1';
                   addOne = false;
               }
            }
        }
        if (alen == blen) {
            if (addOne) {
                chars[0] = '1';
            }else {
                chars[0] = '0';
            }
        }else {
            String maxS = (alen > blen) ? a : b;
            for (int i = maxLen - minLen - 1; i >= 0; i--) {
                if (addOne) {
                    if (maxS.charAt(i) == '1') {
                        chars[i + 1] = '0';
                        addOne = true;
                    }else if(maxS.charAt(i) == '0'){
                        chars[i + 1] = '1';
                        addOne = false;
                    }
                }else {
                    if (maxS.charAt(i) == '1') {
                        chars[i + 1] = '1';
                        addOne = false;
                    }else if(maxS.charAt(i) == '0'){
                        chars[i + 1] = '0';
                        addOne = false;
                    }
                }
            }
            if (addOne) {
                chars[0] = '1';
            }else {
                chars[0] = '0';
            }
        }
        String result = "";
        for (char c: chars) {
            result += c;
        }
        if (result.charAt(0) == '0') result = result.substring(1);
        return result;
    }

}
