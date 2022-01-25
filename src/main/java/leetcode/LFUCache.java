package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private int cap;
    private int size;
    private Map<Integer,ListNode> cache;
    private Map<Integer,List> listMap;

    public LFUCache(int capacity) {
        cap=capacity;
        size=0;
        cache=new HashMap<>();
        listMap=new HashMap<>();

    }

    public int get(int key) {
        return 1;
    }

    public void put(int key, int value) {

    }

    private static class ListNode {
        int value;
        ListNode pre;
        ListNode after;

        public ListNode(int value) {
            this.value = value;
        }
    }

    private static class List {
        ListNode head;
        ListNode tail;
    }
}
