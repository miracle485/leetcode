package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/4/9
 **/
public class LeetCode1026 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(8);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(10);
        child(t1, t2, treeNode);
        TreeNode t3 = getNode(1);
        TreeNode t4 = getNode(6);
        child(t3, t4, t1);
        TreeNode t5 = getNode(4);
        TreeNode t6 = getNode(7);
        child(t5, t6, t4);
        TreeNode t7 = getNode(14);
        child(null, t7, t2);
        TreeNode t8 = getNode(13);
        child(t8, null, t7);
        LeetCode1026 leetCode1026 = new LeetCode1026();
        leetCode1026.maxAncestorDiff(treeNode);
    }

    private static TreeNode getNode(int val) {
        return new TreeNode(val);
    }

    private static void child(TreeNode left, TreeNode right, TreeNode father) {
        father.left = left;
        father.right = right;
    }

    public int maxAncestorDiff(TreeNode root) {

        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode now, int max, int min) {
        int result = Math.max(Math.abs(now.val - max), Math.abs(now.val - min));
        if (now.left != null) {
            int leftMax = dfs(now.left, Math.max(max, now.val), Math.min(min, now.val));
            result = Math.max(leftMax, result);
        }
        if (now.right != null) {
            int rightMax = dfs(now.right, Math.max(max, now.val), Math.min(min, now.val));
            result = Math.max(rightMax, result);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
