package offer;

public class Offer024 {
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode now = head;

        while (now != null) {
            ListNode next = now.next;
            now.next = result;
            result = now;
            now = next;
        }


        return result;
    }

    public class ListNode {
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
