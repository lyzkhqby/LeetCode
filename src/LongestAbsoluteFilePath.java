/**
 * Created by zk on 2016/12/7.
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length + 1];
        int maxLen = 0;
        for (String s : paths) {
            int lev = s.lastIndexOf("\t") + 1, curLen = stack[lev + 1] = stack[lev] + s.length() - lev + 1;// remove "/t", add"/"
            if (s.contains(".")) maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
