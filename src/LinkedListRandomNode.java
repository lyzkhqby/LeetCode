import java.util.Random;

/**
 * Created by rotoosoft-d04 on 2016/8/27.
 */
public class LinkedListRandomNode {
    ListNode head = null;
    Random random = null;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode res = null;
        ListNode cur = head;
        for (int i = 1; cur != null; i++) {
            if (random.nextInt(i) == 0) {
                res = cur;
            }
            cur = cur.next;
        }
        return res.val;
    }
    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(head);
     * int param_1 = obj.getRandom();
     */

//    思路分析： 因为链表的长度不固定，也没法通过下标取值，只能一边遍利，一边取值 考虑在遍历时候，动态记录长度n，然后保证当前值的返回概率是1/n，我们以第2个数为例（就是head.next.val）选取的概率为(1/2) （2/3）（3/4） ……….. (n-1) / n = 1/n （选取第2个数在长度为2的时候为1/2，其他的都不要选)而对于任意的第x数，由于可以覆盖前面的数，均有： (1/x) (x/(x+1)) *…….(n-1) / n = 1/n 第n个数就直接1/n
//    作者： fengsehng
//    链接：http://www.imooc.com/article/12349
//    来源：慕课网
}
