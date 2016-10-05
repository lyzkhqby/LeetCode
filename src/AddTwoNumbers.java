/**
 * Created by zk on 2016/10/5.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        boolean addOne = false;
        ListNode t1 = l1, t2 = l2, th = head;
        while (t1 != null || t2 != null) {
            int total = 0;
            if (t1 == null) total = t2.val;
            else if (t2 == null) total = t1.val;
            else total = t1.val + t2.val;
            if (addOne) {
                total++;
                addOne = false;
            }
            if (total >= 10) {
                total %= 10;
                addOne = true;
            }
            th.next = new ListNode(total);
            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
            th = th.next;
            if ((t1 == null && t2 == null) && addOne) th.next = new ListNode(1);

        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
