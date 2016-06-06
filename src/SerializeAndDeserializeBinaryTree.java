import java.util.ArrayList;

/**
 * Created by zk on 2016/6/7.
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "{}";
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode t = queue.get(i);
            if(t == null) continue;
            queue.add(t.left);
            queue.add(t.right);
        }
        while(queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if(queue.get(i) == null) {
                sb.append(",#");
            }else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeft = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode t = new TreeNode(Integer.parseInt(vals[i]));
                if(isLeft) {
                    queue.get(index).left = t;
                }else {
                    queue.get(index).right = t;
                }
                queue.add(t);
            }
            if(!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
