import java.util.Arrays;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

 However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

 You need to return the least number of intervals the CPU will take to finish all the given tasks.

 Example 1:
 Input: tasks = ["A","A","A","B","B","B"], n = 2
 Output: 8
 Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 Note:
 1.The number of tasks is in the range [1, 10000].
 2.The integer n is in the range [0, 100].
Solution：
 https://leetcode.com/problems/task-scheduler/solution/
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (int i = 0, len = tasks.length; i < len; i++) {
            map[tasks[i] - 'A']++;
        }
        Arrays.sort(map);
        int maxValue = map[25] - 1, idleSlots = maxValue * n;
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(map[i], maxValue);//min 是为了最大的不止一个
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;  //判断大于0是为了n=0的情况

    }
}
