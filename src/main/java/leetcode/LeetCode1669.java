package leetcode;

public class LeetCode1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int now = 0;
        ListNode l1start = null;
        ListNode l1End = null;
        ListNode node = list1;
        ListNode l2Start = list2;
        ListNode l2End = null;
        while (list2 != null) {
            if (list2.next == null) {
                l2End = list2;
            }
            list2 = list2.next;
        }
        ListNode pre = null;
        while (node != null) {
            if (now == a) {
                l1start = pre;
            }
            if (now == b) {
                l1End = node;
            }
            pre = node;
            node = node.next;
            now++;
        }
        l1start.next = l2Start;
        l2End.next = l1End.next;
        return list1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
