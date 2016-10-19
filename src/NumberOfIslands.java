import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zk on 2016/10/19.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        int lenRow = grid.length, lenCol = grid[0].length;
        for (int i = 0; i < lenRow; i++) {
            for (int j = 0; j < lenCol; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    helper(grid, i, j);
                }
            }
        }
        return res;
    }

    private void helper(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i, j});
        while (queue.peek() != null) {
            int[] temp = queue.poll();
            grid[temp[0]][temp[1]] = 0;
            if (temp[0] - 1 > 0 && grid[temp[0] - 1][temp[1]] == '1') queue.offer(new int[]{temp[0] - 1,temp[1]});
            if (temp[0] + 1 < grid.length && grid[temp[0] + 1][temp[1]] == '1') queue.offer(new int[]{temp[0] + 1,temp[1]});
            if (temp[1] - 1 > 0 && grid[temp[0]][temp[1] - 1] == '1') queue.offer(new int[]{temp[0],temp[1] - 1});
            if (temp[1] + 1 < grid[0].length && grid[temp[0]][temp[1] + 1] == '1') queue.offer(new int[]{temp[0],temp[1] + 1});
        }
    }
}
