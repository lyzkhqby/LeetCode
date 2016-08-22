/**
 * Created by rotoosoft-d04 on 2016/8/22.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode little = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode dummyL = little;
        ListNode dummyB = big;

        while (head != null) {
            if (head.val < x) {
                little.next = head;
                head = head.next;
                little = little.next;
                little.next = null;
            }else {
                big.next = head;
                head = head.next;
                big = big.next;
                big.next = null;
            }

        }

        little.next = dummyB.next;
        return dummyL.next;

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
