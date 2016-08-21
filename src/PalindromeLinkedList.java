/**
 * Created by zk on 2016/8/21.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        ListNode cur = head, rev = null;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            cur.next = rev;
            rev = cur;
            cur = slow;
        }

        if (fast != null) slow = slow.next;

        while (rev != null) {
            if (rev.val != slow.val) return false;
            rev = rev.next;
            slow = slow.next;
        }

        return true;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
