package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode1110 {
    private Set<Integer> delSet;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        TreeNode[] parent = new TreeNode[1000];
        delSet = new HashSet<>();
        for (int del : to_delete) {
            delSet.add(del);
        }
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();


        queue.add(root);
        Map<Integer, TreeNode> resultMap = new HashMap<>();
        resultMap.put(root.val, root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                parent[poll.left.val] = poll;
                queue.offer(poll.left);

            }
            if (poll.right != null) {
                parent[poll.right.val] = poll;
                queue.offer(poll.right);
            }

            if (!delSet.contains(poll.val)) {
                continue;
            }
            TreeNode remove = resultMap.remove(poll.val);

            if (parent[poll.val]!=null){
                if (parent[poll.val].left == poll) {
                    parent[poll.val].left = null;
                }
                if (parent[poll.val].right == poll) {
                    parent[poll.val].right = null;
                }
            }



            if (poll.left != null) {
                resultMap.put(poll.left.val, poll.left);
            }
            if (poll.right != null) {
                resultMap.put(poll.right.val, poll.right);
            }

        }
        for (Map.Entry<Integer, TreeNode> treeNodeEntry : resultMap.entrySet()) {
            result.add(treeNodeEntry.getValue());
        }


        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);

        LeetCode1110 leetCode1110 = new LeetCode1110();
        leetCode1110.delNodes(root, new int[]{2, 3});
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
