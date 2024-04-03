package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author = wangyilin29
 * @date = 2024/4/2
 */
public class LeetCode894 {
    private int[] dis;


    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n % 2 == 0) {
            return result;
        }
        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        for (int i = 1; i < n - 1; i += 2) {
            List<TreeNode> leftList = allPossibleFBT(i);
            List<TreeNode> rightList = allPossibleFBT(n - i - 1);

            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode treeNode = new TreeNode(0, left, right);
                    result.add(treeNode);
                }
            }
        }
        return result;
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
