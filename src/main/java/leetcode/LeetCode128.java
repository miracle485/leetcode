package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        Map<Integer, Integer> numMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        int[] parent = new int[nums.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            numMap.put(nums[i], i);
            countMap.put(i, 1);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer p = numMap.get(nums[i] - 1);
            if (p == null || numMap.get(nums[i]) != i) {
                continue;
            }
            if (findParent(i, parent) != findParent(p, parent)) {
                Integer count = countMap.get(parent[i]);
                Integer pCount = countMap.get(parent[p]);
                union(p, i, parent);
                result = Math.max(count + pCount, result);
                countMap.put(parent[p], count + pCount);
            }
        }

        return result;
    }

    public int findParent(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = findParent(parent[x], parent);
        return parent[x];
    }

    public void union(int x, int y, int[] parent) {
        int xRoot = findParent(x, parent);
        int yRoot = findParent(y, parent);
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};

        LeetCode128 leetCode128 = new LeetCode128();
        System.out.println(leetCode128.longestConsecutive(nums));
    }
}
