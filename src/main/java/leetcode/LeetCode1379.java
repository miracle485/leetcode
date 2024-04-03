package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/4/3
 */
public class LeetCode1379 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return dfs(cloned, target);
    }

    public TreeNode dfs(TreeNode cloned, TreeNode target) {
        if (cloned == null) {
            return null;
        }
        if (target.val == cloned.val) {
            return cloned;
        }
        TreeNode result = dfs(cloned.left, target);
        if (result == null) {
            result = dfs(cloned.right, target);
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
