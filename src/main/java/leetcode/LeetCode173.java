package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode173 {
    private List<Integer> treeNodes = new ArrayList<>();
    private int now = 0;

    private LeetCode173(TreeNode root) {
        middleTree(root);
    }

    /**
     * 扁平化处理
     * @param treeNode
     */
    private void middleTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        middleTree(treeNode.left);
        treeNodes.add(treeNode.val);
        middleTree(treeNode.right);
    }

    public int next() {
        return treeNodes.get(now++);
    }

    public boolean hasNext() {
        return now < treeNodes.size();
    }

    public class TreeNode {
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
