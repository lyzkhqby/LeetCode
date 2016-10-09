/**
 * Created by rotoosoft-d04 on 2016/10/9.
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = null;
        if (head.next != null)  {
            ListNode next = head.next;
            head.next = null;
            while (next != null) {
                newHead = head;
                head = next;
                next = next.next;
                head.next = newHead;

            }
        }
        return head;
    }


    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = head.next;
        ListNode reverseRest = reverseList(rest);
        rest.next = head;
        head.next = null;
        return reverseRest;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
