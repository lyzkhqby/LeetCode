import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rotoosoft-d04 on 2016/9/5.
 */
public class ImplementStackUsingQueues {

   Queue<Integer> q = new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        q.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
        q.poll();
    }

    // Get the top element.
    public int top() {
        int res = 0;
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
        res = q.peek();
        q.offer(q.poll());
        return res;

    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}
