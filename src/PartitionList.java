/**
 * Created by rotoosoft-d04 on 2016/8/22.
 */
/**
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
