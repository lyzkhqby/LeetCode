/**
 * Created by rotoosoft-d04 on 2016/5/24.
 */
public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null && root.right == null) return;
        if (root.left != null && root.right != null) root.left.next = root.right;
        TreeLinkNode q = root.next;
        while(q != null && q.left == null && q.right == null)  {
            q = q.next;

        }
        if (q != null) {
            TreeLinkNode p;
            p = root.left;
            if(root.right != null) p = root.right;
            p.next = q.right;
            if(q.left != null) p.next = q.left;
        }
        connect(root.right);//{2,1,3,0,7,9,1,2,#,1,0,#,#,8,8,#,#,#,#,7}先写right的原因
        connect(root.left);
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
