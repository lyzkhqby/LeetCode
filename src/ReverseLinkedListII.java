/**
 * Created by zk on 2016/10/12.
 */
public class ReverseLinkedListII {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (n == m) return head;
        int step = n - m;
        ListNode Head = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        int m1 = m;
        while (m1 > 1) {
            pre = head;
            head = head.next;
            m1--;
        }
        ListNode newHead = pre;
        while (step >= 0) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
            step--;
        }
        pre.next = newHead;
        step = n - m;
        while (step > 0) {
            newHead = newHead.next;
            step--;
        }
        newHead.next = head;
        if (m == 1) return pre.next;
        return Head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode res = reverseBetween(n1, 2, 3);
        System.out.print(res.val);
    }
}
