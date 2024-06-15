package leetcode;

public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pLeft = preHead;
        for (int i = 0; i < left; i++) {
            pLeft = pLeft.next;
        }
        ListNode curr = pLeft.next;
        ListNode pre = pLeft;
        while (left <= right) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;

            left++;
        }
        if (pLeft.next != null) {
            pLeft.next.next = curr;
        }
        pLeft.next = pre;

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
