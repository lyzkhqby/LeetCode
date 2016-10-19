import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zk on 2016/10/19.
 */
public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
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

    private static void helper(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i, j});
        while (queue.peek() != null) {

//            int[] tempq = queue.peek();
//            System.out.print(Integer.toString(tempq[0]) +","+ Integer.toString(tempq[1]) + "\n");
//            System.out.print("++++++++++++++++++++\n");
            int[] temp = queue.poll();
            grid[temp[0]][temp[1]] = '0';
            int[] up = new int[]{temp[0] - 1,temp[1]};
            if (temp[0] - 1 >= 0 && grid[temp[0] - 1][temp[1]] == '1' && !contains(queue, up))
                queue.offer(up);
            int[] down = new int[]{temp[0] + 1,temp[1]};
            if (temp[0] + 1 < grid.length && grid[temp[0] + 1][temp[1]] == '1' && !contains(queue, down))
                queue.offer(down);
            int[] left = new int[]{temp[0],temp[1] - 1};
            if (temp[1] - 1 >= 0 && grid[temp[0]][temp[1] - 1] == '1'
                    && !contains(queue, left)) queue.offer(left);
            int[] right = new int[]{temp[0],temp[1] + 1};
            if (temp[1] + 1 < grid[0].length && grid[temp[0]][temp[1] + 1] == '1'
                    && !contains(queue,right)) queue.offer(right);

        }
    }

    private static boolean contains(Queue<int[]> queue, int[] ints) {
        for (int[] item : queue) {
            if (item[0] == ints[0] && (item[1] == ints[1]))  return true;
        }
        return false;
    }

    private static void printGrid(char[][] grid, Queue<int[]> queue) {
        int lenR = grid.length, lenC = grid[0].length;
        for (int i = 0; i < lenR; i++) {
            for (int j = 0; j < lenC; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }


        System.out.print("---------------------\n");
    }

    public static void main(String[] args) {
        String[] strs = {"11111011111111101011",
                         "01111111111110111110",
                         "10111001101111111111",
                         "11110111111111111111",
                         "10011111111111111111",
                         "10111111011101110111",
                         "01111111111101101111",
                         "11111111111101111011",
                         "11111111110111111111",
                         "11111111111111111111",
                         "01111111011111111111",
                         "11111111111111111111",
                         "11111111111111111111",
                         "11111011111110111111",
                         "10111110111011110111",
                         "11111111111101111110",
                         "11111111111110111100",
                         "11111111111111111111",
                         "11111111111111111111",
                         "11111111111111111111"};
        char[][] grid = tran(strs);
        System.out.print(numIslands(grid));
    }

    private static char[][] tran(String[] strs) {
        int len = strs.length;
        int itemLen = strs[0].length();
        char[][] res = new char[len][itemLen];
        for (int i = 0; i < len; i++) {
            String item = strs[i];
            char[] chars = new char[itemLen];
            for (int j = 0; j < itemLen; j++) {
                chars[j] = item.charAt(j);
            }
            res[i] = chars;
        }
        return res;
    }


}
