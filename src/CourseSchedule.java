import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zk on 2016/10/19.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> posts = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            posts.add(new ArrayList<>());
        }

        int[] preNum = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
            preNum[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (preNum[i] == 0) queue.offer(i);
        }

        int count = numCourses;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i : posts.get(cur)) {
                if (--preNum[i] == 0) {
                    queue.offer(i);
                }
            }
            count--;
        }

        return count == 0;
    }
}
