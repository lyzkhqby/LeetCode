import java.util.ArrayList;
import java.util.List;

/**
 * Created by zk on 2016/11/20.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        if (n <= 0) return list;
        int[] row = new int[n];
        solveNQueensCore(list, row, n, 0);
        return list;
    }

    private void solveNQueensCore(List<List<String>> resList, int[] row, int n, int index) {

        if (index == n) {
            List<String> singleRes = translateString(row);
            resList.add(singleRes);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(row, index, i)) {
                row[index] = i;
                solveNQueensCore(resList, row, n, index + 1);

            }
        }
    }

    private List<String> translateString(int[] row) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < row.length; j++) {
                if (j == row[i]) {
                    sb.append('Q');
                }else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }



    private boolean isValid(int[] row, int rowNum, int columnNum) {
        for (int i = 0; i < rowNum; i++) {
            if (row[i] == columnNum) {
                return false;
            }
            if (Math.abs(columnNum - row[i]) == Math.abs(rowNum - i)) {
                return false;
            }
        }
        return true;
    }
}
