package unionfind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by zk on 2016/11/6.
 * 给出方程式A / B = k, 其中A 和B 均为用字符串表示的变量，k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回-1.0。
 *
 * 示例 :
 * 给定a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 返回[6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>>
 *     queries(方程式，方程式结果，问题方程式)，其中equations.size() == values.size()，
 * 即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。返回vector<double>类型。
 *
 * 基于上述例子，输入如下：
 *
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EvaluateDivision {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<>();
        HashMap<String, ArrayList<Double>> valuePairs = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuePairs.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuePairs.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuePairs.get(equation[0]).add(values[i]);
            valuePairs.get(equation[1]).add(1 / values[i]);
        }
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuePairs, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) result[i] = -1.0;
        }
        return result;
    }

    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> valuePairs,
                       HashSet<String> set, double value) {
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);

        ArrayList<String> startList = pairs.get(start);
        ArrayList<Double> valuesList = valuePairs.get(start);

        double tmp = 0.0;
        for (int i = 0; i < startList.size(); i++) {
            tmp = dfs(startList.get(i), end, pairs, valuePairs, set, value * valuesList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
        return tmp;
    }
}
