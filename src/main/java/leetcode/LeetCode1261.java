package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
  @author = wangyilin29
  @date = 2024/3/12
 */
public class LeetCode1261 {
    private final Set<Integer> result = new HashSet<>();

    public void FindElements(TreeNode root) {
        root.val = 0;
        result.add(0);
        dfs(root);
    }

    public void dfs(TreeNode node) {
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            result.add(node.left.val);
            dfs(node.left);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 1;
            result.add(node.right.val);
            dfs(node.right);
        }
    }

    public boolean find(int target) {
        return result.contains(target);
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
