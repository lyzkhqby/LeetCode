import java.util.Stack;

/**
 * Created by rotoosoft-d04 on 2016/9/5.
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> temp = new Stack<>();
        int size = s1.size();
        for (int i = 0; i < size; i++) {
            temp.push(s1.pop());
        }
        temp.pop();
        int sizeT = temp.size();
        for (int i = 0; i < sizeT; i++) {
            s1.push(temp.pop());
        }
    }

    // Get the front element.
    public int peek() {
        int res = 0;
        Stack<Integer> temp = new Stack<>();
        int size = s1.size();
        for (int i = 0; i < size; i++) {
            temp.push(s1.pop());
        }
        res = temp.peek();
        for (int i = 0; i < size; i++) {
            s1.push(temp.pop());
        }
        return res;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty();
    }
}
