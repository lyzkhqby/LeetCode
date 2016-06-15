/**
 * Created by rotoosoft-d04 on 2016/6/15.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pivot = head;
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(-1);
        ListNode leftHead = left;
        ListNode rightHead = right;
        ListNode pivotHead = pivot;
        ListNode crt = head.next;

        while (crt != null) {
            if(crt.val < pivot.val) {
                left.next = crt;
                left = left.next;
            }else if(crt.val > pivot.val) {
                right.next = crt;
                right = right.next;
            }else {
                pivot.next = crt;
                pivot = pivot.next;
            }
            crt = crt.next;
        }

        pivot.next = null;
        left.next = null;
        right.next = null;
        left = sortList(leftHead.next);
        right = sortList(rightHead.next);
        pivot.next = right;
        ListNode res = left;

        while(left != null && left.next != null) left = left.next;

        if(left == null) {
            res = pivotHead;
        }else {
            left.next = pivotHead;
        }

        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
