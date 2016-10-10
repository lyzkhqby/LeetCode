/**
 * Created by rotoosoft-d04 on 2016/10/10.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        if (head == null) return null;
        ListNode node = head;
        while (node != null && node.next != null) {
            while (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
