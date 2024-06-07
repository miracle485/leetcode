package leetcode;

public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode(0, head);
        ListNode preLeft = preHead;
        for (int i = 0; i < left; i++) {
            preLeft = preLeft.next;
        }

        ListNode pre = null;
        ListNode curr = preLeft.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        preLeft.next.next = curr;
        preLeft.next = pre;
        return preHead.next;
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
