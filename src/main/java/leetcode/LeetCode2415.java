package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode2415 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(5);
        treeNode.left = left;
        treeNode.right = right;
        LeetCode2415 leetCode2415 = new LeetCode2415();
        leetCode2415.reverseOddLevels(treeNode);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return root;
        }
        int v = -1, size = 1;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            List<TreeNode> treeNodeList = new ArrayList<>();
            int cSize = 0;
            while (size > 0) {
                TreeNode poll = treeNodes.poll();
                treeNodeList.add(poll);
                size--;
                if (poll.left != null) {
                    treeNodes.offer(poll.left);
                    treeNodes.offer(poll.right);
                    cSize += 2;
                }
            }
            v++;
            size = cSize;
            if (v % 2 == 0) {
                continue;
            }
            int left = 0, right = treeNodeList.size() - 1;
            while (left <= right) {
                int a = treeNodeList.get(left).val;
                treeNodeList.get(left).val = treeNodeList.get(right).val;
                treeNodeList.get(right).val = a;
                left++;
                right--;
            }
        }
        return root;
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
