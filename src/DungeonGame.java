/**
 * Created by zk on 2016/8/18.
 */
public class DungeonGame {
//    创建一个二维数组来保存记录。
//
//    1首先从重点开始，这里需要注意的是，终点的血量求负之后是需要加1的，例如重点值是-5，那么进入终点时的血量就应该是6，
//    不然到终点血量变为0了也是失败。然后需要注意的是如果进入终点前所需的血量小于1，那么就应该以1记，因为如果是血量小于1就直接失败了。
//    2然后循环运算二维数组中的每个点的最低血量，例如，对于dungeon[i][j]点来说，通过dungeon[i][j]本身需要的血量是-dungeon[i][j]，
//    通过dungeon[i][j]点之后到达终点所需的最小血量为Math.min(dungeon[i + 1][j], dungeon[i][j + 1])，对两者求和，同样的，
//    如果这求和值小于1那么应该以1记，完整递推公式为dungeon[i][j] = Math.max(1, -dungeon[i][j] + Math.min(dungeon[i + 1][j], dungeon[i][j + 1]))。
//    最后返回dungeon[0][0]的值即可。

    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length, cols = dungeon[0].length;
        dungeon[rows - 1][cols - 1] = Math.max(1, -dungeon[rows - 1][cols - 1] + 1);
        for (int j = cols - 2; j >= 0 ; j--) {
            dungeon[rows - 1][j] = Math.max(1, -dungeon[rows - 1][j] + dungeon[rows - 1][j + 1]);
        }

        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if(j == cols - 1) {
                    dungeon[i][j] = Math.max(1, -dungeon[i][j] + dungeon[i + 1][j]);
                }else {
                    dungeon[i][j] = Math.max(1, -dungeon[i][j] + Math.min(dungeon[i + 1][j], dungeon[i][j + 1]));
                }
            }
        }

        return dungeon[0][0];
    }
}
