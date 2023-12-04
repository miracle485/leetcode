package leetcode;

/**
 * @author = wangyilin29
 * @date = 2023/12/4
 **/
public class LeetCode1038 {
    private int preSum;

    public TreeNode bstToGst(TreeNode root) {
        preSum = 0;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        preSum += node.val;
        node.val = preSum;
        dfs(node.left);
    }

    public class TreeNode {
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
