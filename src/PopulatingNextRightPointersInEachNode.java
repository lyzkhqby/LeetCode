import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/4/28.
 */
public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        List<TreeLinkNode> list = new ArrayList<>();
        list.add(root);
        helper(list);
    }

    private void helper(List<TreeLinkNode> list) {
        int len = list.size();
        if (len == 0) return;
        List<TreeLinkNode> temp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            TreeLinkNode cur = list.get(i);
            if (i + 1 >= len) {
                cur.next = null;
            }else {
                cur.next = list.get(i + 1);
            }
            if (cur.left != null) temp.add(cur.left);
            if (cur.right != null) temp.add(cur.right);
        }
        helper(temp);
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
