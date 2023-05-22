package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode173_2 {
    private TreeNode treeNode = null;
    private Deque<TreeNode> deque = new LinkedList<>();

    private LeetCode173_2(TreeNode root) {
        treeNode = root;
    }

    public int next() {
        while (treeNode != null) {
            deque.push(treeNode);
            treeNode = treeNode.left;
        }
        TreeNode result = deque.pop();
        int value = result.val;
        treeNode = result.right;
        return value;
    }

    public boolean hasNext() {
        return deque.isEmpty();
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {this.val = val;}

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
