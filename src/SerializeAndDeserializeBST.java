import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rotoosoft-d04 on 2016/11/7.
 */
public class SerializeAndDeserializeBST {
    private final static String SEP = ",";
    private final static String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return NULL;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while (!st.empty()) {
            root = st.pop();
            sb.append(root.val).append(SEP);
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for (String str : strs) {
            q.offer(Integer.parseInt(str));
        }
        return getNode(q);
    }

    private TreeNode getNode(Queue<Integer> q) {
        if (q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> leftq = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) {
            leftq.offer(q.poll());
        }
        root.left = getNode(leftq);
        root.right = getNode(q);
        return root;
    }

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
