package nowcoder;

public class BM02 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        // write code here
        ListNode nodeM = null;
        ListNode nodeN = null;
        ListNode nodePreM = null;
        ListNode nodeAfterN = null;
        int nowIndex = 0;
        ListNode nowNode = head;
        ListNode pre = null;
        while (nowNode != null) {
            ListNode next = nowNode.next;
            nowIndex++;
            if (nowIndex < m - 1 || nowIndex > n + 1) {
                pre = nowNode;
                nowNode = next;
                continue;
            }

            if (nowIndex == m - 1) {
                nodePreM = nowNode;
            }
            if (nowIndex == m) {
                nodeM = nowNode;
                nodeM.next = null;
            }
            if (nowIndex == n) {
                nodeN = nowNode;
            }
            if (nowIndex == n + 1) {
                nodeAfterN = nowNode;
            }

            if (nowIndex > m && nowIndex <= n) {
                nowNode.next = pre;
            }
            pre = nowNode;
            nowNode = next;
        }
        //1->2<-3<-4 5
        if (nodePreM != null) {
            nodePreM.next = nodeN;
        }
        if (nodeAfterN != null) {
            nodeM.next = nodeAfterN;
        }
        if (m == 1) {
            return nodeN;
        }
        return head;


    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{3, 1, 3, 4, 1, 4, -1};
        BM02 bm02 = new BM02();
        ListNode l1 = new ListNode(nodes[0]);
        ListNode pre = l1;
        for (int i = 1; i < nodes.length; i++) {
            ListNode listNode = new ListNode(nodes[i]);
            pre.next = listNode;
            pre = listNode;
        }

        bm02.reverseBetween(l1, 3, 7);

    }
}
