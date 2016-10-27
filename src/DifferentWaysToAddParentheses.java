import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/10/27.
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if (input == null || input.length() == 0) return res;
        int len = input.length();
        for (int i = 0; i < len; i++) {
            char cur = input.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Res = diffWaysToCompute(part1);
                List<Integer> part2Res = diffWaysToCompute(part2);
                for (int p1 : part1Res) {
                    for (int p2 : part2Res) {
                        int r = 0;
                        switch (cur) {
                            case '+':
                                r = p1 + p2;
                                break;
                            case '-':
                                r = p1 - p2;
                                break;
                            case '*':
                                r = p1 * p2;
                                break;
                        }
                        res.add(r);
                    }

                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}
