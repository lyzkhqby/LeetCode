package design;

import java.util.HashMap;

/**
 * Created by zk on 2016/11/22.
 * 运用你所掌握的数据结构，设计和实现一个LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，
 * 则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *
 * 进阶:
 *
 * 你是否可以在O(1) 时间复杂度内完成这两种操作？
 *
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 缓存容量 );
 *
 *      cache.put(1,1);
 *      cache.put(2,2);
 *      cache.get(1);       // 返回  1
 *      cache.put(3,3);    // 该操作会使得关键字 2 作废
 *      cache.get(2);       // 返回 -1 (未找到)
 *      cache.put(4,4);    // 该操作会使得关键字 1 作废
 *      cache.get(1);       // 返回 -1 (未找到)
 *      cache.get(3);       // 返回  3
 *      cache.get(4);       // 返回  4
 *
 *      来源：力扣（LeetCode）
 *      链接：https://leetcode-cn.com/problems/lru-cache
 *      著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (!hs.containsKey(key)) return -1;

        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);

        return hs.get(key).value;


    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        hs.put(key, insert);
        moveToTail(insert);
    }

    private void moveToTail(Node current) {
        current.prev = tail.prev;
        current.next = tail;
        tail.prev = current;
        current.prev.next = current;
    }

    private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
