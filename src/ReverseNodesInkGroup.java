/**
 * Created by rotoosoft-d04 on 2016/10/17.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while(head.next != null) {
            head = reverseNextK(head, k);
        }
        return dummy.next;

    }

    private ListNode reverseNextK(ListNode head, int k) {
        ListNode next = head;
        for (int i = 0; i < k; i++) {
            if (next.next == null) return next;
            next = next.next;
        }

        ListNode n1 = head.next;
        ListNode pre = head, cur = n1;
        for (int i = 0; i < k; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        n1.next = cur;
        head.next = pre;
        return n1;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
