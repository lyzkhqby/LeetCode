import java.util.*;

/**
 * Created by zk on 2016/10/21.
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }


        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][1]]++;
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] result = new int[numCourses];
        int index = numCourses - 1;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                result[index--] = i;
            }
        }


        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int child : map.get(cur)) {
                if (--indegree[child] == 0) {
                    queue.offer(child);
                    result[index--] = child;
                }
            }
        }

        if (index != -1) return new int[0];

        return result;

    }
}
