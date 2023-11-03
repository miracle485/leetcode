package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        int size = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int s = size;
            size = 0;
            while (s > 0) {
                s--;
                Node poll = queue.poll();
                if (s > 0) {
                    poll.next = queue.peek();
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                    size++;
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                    size++;
                }

            }

        }


        return root;
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
