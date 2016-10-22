import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zk on 2016/10/22.
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            tryMarking(board, i, 0, queue);
            tryMarking(board, i, n - 1, queue);
        }

        for (int i = 0; i < n; i++) {
            tryMarking(board, 0, i, queue);
            tryMarking(board, m - 1, i, queue);
        }


        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int x = cur.x, y = cur.y;
            if (x - 1 >= 0) tryMarking(board, x - 1, y, queue);
            if (x + 1 < m) tryMarking(board, x + 1, y, queue);
            if (y - 1 >= 0) tryMarking(board, x, y - 1, queue);
            if (y + 1 < n) tryMarking(board, x, y + 1, queue);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '+') board[i][j] = 'O';
            }
        }
    }


    private void tryMarking(char[][] board, int i, int j, Queue<Point> queue) {
        if (board[i][j] == 'O') {
            board[i][j] = '+';
            queue.offer(new Point(i, j));
        }
    }

    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
