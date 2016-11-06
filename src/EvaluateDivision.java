import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by zk on 2016/11/6.
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
