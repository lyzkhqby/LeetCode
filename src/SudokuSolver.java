/**
 * Created by rotoosoft-d04 on 2016/9/20.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }

    private boolean solve(char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
        }

        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) return false;
        }

        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }

        return true;
    }
}
