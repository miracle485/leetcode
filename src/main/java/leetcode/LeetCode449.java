package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> k = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        return builder.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {val = x;}
    }
}
