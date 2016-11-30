/**
 * Created by zk on 2016/12/1.
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rowLen = grid.length, colLen = grid[0].length;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) return dfs(grid, i, j);
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 1;
        if (grid[i][j] == 0) return 1;
        if (grid[i][j] == -1) return 0;
        grid[i][j] = -1;
        return dfs(grid, i + 1, j) + dfs(grid, i, j + 1)
                + dfs(grid, i, j - 1) + dfs(grid, i - 1, j);

    }
}
