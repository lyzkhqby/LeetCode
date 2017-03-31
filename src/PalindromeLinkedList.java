/**
 * Created by zk on 2016/8/21.
 */
/**
 Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?
 */
/**
 判断 fast ！= null 是为了[1, 2]类似的特殊情况
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
