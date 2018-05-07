/**
 * Created by rotoosoft-d04 on 2016/8/24.
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 * 你是否可以不用额外空间解决此题？
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
