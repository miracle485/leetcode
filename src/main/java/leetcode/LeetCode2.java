package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode now = null;
        int y = 0;
        while (l1 != null || l2 != null) {
            int value = 0;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            value += y;
            y = value / 10;
            value = value % 10;
            ListNode next = new ListNode(value);
            if (result != null) {
                now.next = next;
                now = next;
            } else {
                result = next;
                now = next;
            }
        }
        if (y != 0) {
            ListNode listNode = new ListNode(y);
            now.next=listNode;
        }

        return result;
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
}
