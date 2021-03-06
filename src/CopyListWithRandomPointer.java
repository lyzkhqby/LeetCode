import java.util.HashMap;
import java.util.Map;

/**
 * Created by rotoosoft-d04 on 2016/9/23.
 */
/**
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            RandomListNode newNode = entry.getValue();
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
        }

        return map.get(head);
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
}
