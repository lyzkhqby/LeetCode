/**
 * Created by rotoosoft-d04 on 2016/8/24.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow1 = head;
                while (slow1 != slow) {
                    slow1 = slow1.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }
}
