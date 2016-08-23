/**
 * Created by rotoosoft-d04 on 2016/8/23.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        if (k < 0) return null;
        if (k == 0) return head;

        int len = 0;
        ListNode counter = head;
        while (counter != null)  {
            len++;
            counter = counter.next;
        }

        int num = k % len;
        if (num == 0) {
            return head;
        }else {
            return rotate(head, num);
        }
    }

    private ListNode rotate(ListNode head, int account) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode res = new ListNode(0);

        ListNode pre = head;
        for (int i = 0; i < account; i++) {
            head = head.next;
        }
        while (head != null && head.next != null) {
            head = head.next;
            pre = pre.next;
        }
        res.next = pre.next;
        head.next = dummy.next;
        pre.next = null;
        return res.next;
    }

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }
}
