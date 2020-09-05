package stack;

/**
 * Created by zk on 2016/6/26.
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例5:
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            switch(c) {
                case '(':
                case '{':
                case '[':
                    stack[head++] = c;
                    break;
                case ']':
                    if(head == 0 || stack[--head] != '[') return false;
                    break;
                case '}':
                    if(head == 0 || stack[--head] != '{') return false;
                    break;
                case ')':
                    if(head == 0 || stack[--head] != '(') return false;
                    break;
            }
        }
        return head == 0;
    }
}
