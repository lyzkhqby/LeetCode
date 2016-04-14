import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by rotoosoft-d04 on 2016/4/14.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(1, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode result = new ListNode(0);
        ListNode header = result;
        result.next = null;
        for (ListNode list : lists) {
            if (list != null) heap.offer(list);
        }

        while (!heap.isEmpty()) {
            ListNode temp = heap.poll();
            if (temp.next != null) {
                heap.offer(temp.next);
            }
            result.next = temp;
            result = result.next;
        }
        result.next = null;
        return header.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
