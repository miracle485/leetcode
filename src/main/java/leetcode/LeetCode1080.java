package leetcode;

public class LeetCode1080 {
    private int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        boolean limited = isLimited(0, root);
        if (limited) {
            return null;
        }

        return root;
    }


    private boolean isLimited(int pre, TreeNode node) {
        if (node.left == null && node.right == null) {
            boolean needDeleted = (pre + node.val) < limit;
            if (needDeleted) {
                node.val = Integer.MIN_VALUE;
            }

            return needDeleted;
        }
        boolean leftDeleted = false;
        boolean rightDeleted = false;
        if (node.left != null) {
            leftDeleted = isLimited(pre + node.val, node.left);
            if (leftDeleted) {
                node.left = null;
            }
        } else {
            leftDeleted = true;
        }
        if (node.right != null) {
            rightDeleted = isLimited(pre + node.val, node.right);
            if (rightDeleted) {
                node.right = null;
            }
        } else {
            rightDeleted = true;
        }
        if (leftDeleted && rightDeleted) {
            node.val = Integer.MIN_VALUE;
        }

        return leftDeleted && rightDeleted;
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(-5);
        root.right.left = new TreeNode(4);


        LeetCode1080 leetCode1080 = new LeetCode1080();
        leetCode1080.sufficientSubset(root, -1);
    }
}
