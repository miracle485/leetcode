package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode143 {
    public void reorderList(ListNode head) {
        List<ListNode> ori = new ArrayList<>();
        int all = 0;
        while (head != null) {
            ori.add(head);
            head = head.next;
            all++;
        }

        int o = 0;
        int r = ori.size() - 1;
        for (int i = 1; i <= all; i++) {
            ListNode next = null;
            ListNode now = null;
            if (i % 2 == 1) {
                now = ori.get(o);
                if (r >= 0) {
                    next = ori.get(r);
                }
                o++;
            } else {
                now = ori.get(r);
                if (o < ori.size()) {
                    next = ori.get(o);
                }
                r--;
            }
            now.next = next;
            next.next = null;

        }

    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LeetCode143 leetCode143 = new LeetCode143();
        ListNode head = new ListNode(1);
        ListNode now = head;
        for (int i = 2; i <= 4; i++) {
            now.next = new ListNode(i);
            now = now.next;
        }
        leetCode143.reorderList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
