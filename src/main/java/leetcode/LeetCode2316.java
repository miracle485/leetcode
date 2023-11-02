package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2316 {
    Map<Integer, Integer> parentMap;
    Map<Integer, Integer> countMap;

    public long countPairs(int n, int[][] edges) {
        long result = 0;
        parentMap = new HashMap<>();
        countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            parentMap.put(i, i);
            countMap.put(i, 1);
        }

        for (int[] edge : edges) {
            if (findParent(edge[0]) != findParent(edge[1])) {
                union(edge[0], edge[1]);
            }
        }

        for (Integer value : parentMap.values()) {
            result += n - countMap.get(findParent(value));
        }

        return result;
    }

    public int findParent(int x) {
        if (parentMap.get(x) == x) {
            return x;
        }

        int p = parentMap.get(x);
        int result = findParent(p);
        if (p != result) {
            parentMap.put(p, result);
        }
        return result;
    }

    public void union(int x, int y) {
        int xP = findParent(x);
        int yP = findParent(y);
        if (xP != yP) {
            parentMap.put(yP, xP);
            int yPC = countMap.get(yP);
            countMap.put(xP, countMap.get(xP) + yPC);
            countMap.remove(yP);
        }
    }

    public static void main(String[] args) {
        int[][] edg = new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};
        int n = 7;
        LeetCode2316 leetCode2316 = new LeetCode2316();
        leetCode2316.countPairs(n, edg);
    }
}
