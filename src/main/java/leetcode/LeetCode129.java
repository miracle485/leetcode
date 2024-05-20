package leetcode;

public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        return dfsSum(root, 0);
    }

    public int dfsSum(TreeNode node, int parent) {
        int now = parent * 10 + node.val;
        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = dfsSum(node.left, now);
        }
        if (node.right != null) {
            right = dfsSum(node.right, now);
        }
        return (left == 0 && right == 0) ? now : (left + right);
    }

    private static class TreeNode {
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
