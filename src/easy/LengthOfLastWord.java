package easy;

/**
 * Created by rotoosoft-d04 on 2016/6/24.
 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

 如果不存在最后一个单词，请返回 0 。

 说明：一个单词是指由字母组成，但不包含任何空格的字符串。

 示例:

 输入: "Hello World"
 输出: 5
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
