package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zk on 2016/10/23.
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，
 * 具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 *
 * 格式
 *
 * 该图包含n个节点，标记为0到n - 1。给定数字n和一个无向边edges列表（每一个边都是一对标签）。
 *
 * 你可以假设没有重复的边会出现在edges中。由于所有的边都是无向边， [0, 1]和[1, 0]是相同的，因此不会同时出现在edges里。
 *
 * 示例 1:
 *
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 *
 * 输出: [1]
 * 示例 2:
 *
 * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * 输出: [3, 4]
 * 说明:
 *
 * 根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaf = new ArrayList<>();
        if (n <= 1) {
            leaf.add(0);
            return leaf;
        }

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());

        int[] neighbors = new int[n];
        for (int[] edge : edges) {
            neighbors[edge[0]]++;
            neighbors[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) leaf.add(i);
        }

        while (n > 2) {
            List<Integer> newLeaf = new ArrayList<>();
            for (int l : leaf) {
                n--;
                for (int nb : graph.get(l)) {
                    if (--neighbors[nb] == 1) newLeaf.add(nb);
                }
            }
            leaf = newLeaf;
        }
        return leaf;
    }

    public static void main(String[] args) {
        MinimumHeightTrees trees = new MinimumHeightTrees();
        int n = 6;
        int[][] array = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        trees.findMinHeightTrees(n, array);
    }

}
