/**
 * Created by zk on 2016/10/13.
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while (fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
            }
            if (slow.next != fast) {
                slow.next = fast.next;
                fast = slow.next;
            }else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
