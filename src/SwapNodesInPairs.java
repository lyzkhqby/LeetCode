import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/10/11.
 */
public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode node = head;
        head = head.next;
        while (node != null && node.next != null) {
            ListNode temp = node.next.next;
            node.next.next = node;
            pre.next = node.next;
            node.next = temp;
            pre = node;
            node = node.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        swapPairs(n1);

        ListNode node = n2;
        while (node != null) {
            System.out.print(Integer.toString(node.val) + '\n');
            node = node.next;
        }
    }
}
