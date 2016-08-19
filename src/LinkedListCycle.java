/**
 * Created by rotoosoft-d04 on 2016/8/19.
 */
public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }else {
                return false;
            }
            if (fast == slow) return true;
        }

        return false;

    }
}
