package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int size;
    private int cap;
    private Map<Integer, ListNode> cache;
    private Deque<ListNode> page;
    private final ListNode header = new ListNode(-1, -1);
    private final ListNode tail = new ListNode(-1, -1);


    public LRUCache(int capacity) {
        size = 0;
        cap = capacity;
        cache = new HashMap<>();
        page = new LinkedList<>();
        header.after = tail;
        tail.pre = header;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        ListNode.removeNode(node);
        ListNode.putToList(tail,node);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        ListNode now = new ListNode(key, value);
        if (size == 0) {
            size++;
            cache.put(key, now);
            header.after = now;
            now.pre=header;
            now.after=tail;
            tail.pre = now;
            return;
        }
        ListNode pre = cache.get(key);
        ListNode.putToList(tail, now);
        cache.put(key,now);
        if (pre != null) {
            ListNode.removeNode(pre);
        } else {
            if (size == cap) {
                cache.remove(header.after.key);
                ListNode.removeHead(header);

            }else {
                size++;
            }
        }

    }

    private static class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode after;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public static void putToList(ListNode tail, ListNode now) {
            if (now==null){
                return;
            }
            now.after = tail;
            now.pre = tail.pre;
            tail.pre.after = now;
            tail.pre = now;
        }

        public static void removeHead(ListNode head) {
            if (head.after.after != null) {
                head.after.after.pre = head;
            }
            head.after = head.after.after;
        }
        public static void removeNode(ListNode node){
            if (node==null){
                return;
            }
            node.pre.after = node.after;
            node.after.pre = node.pre;
        }
    }

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(1));
    }
}
