/**
 * Created by zk on 2016/11/21.
 */
public class NQueensII {
    private int sum;
    public int totalNQueens(int n) {
        sum = 0;
        int[] usedColumns = new int[n];
        placeQueen(usedColumns, 0);
        return sum;
    }

    private void placeQueen(int[] usedColumns, int row) {
        int len = usedColumns.length;
        if (row == len) {
            sum++;
            return;
        }
        for (int i = 0; i < len; i++) {
            if (isValid(usedColumns, row, i)) {
                usedColumns[row] = i;
                placeQueen(usedColumns, row + 1);
            }
        }
    }

    private boolean isValid(int[] usedColumns, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (usedColumns[i] == col) return false;
            if (row - i == Math.abs(usedColumns[i] - col)) return false;
        }
        return true;
    }
}
