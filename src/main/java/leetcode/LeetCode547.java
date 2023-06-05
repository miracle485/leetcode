package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode547 {
    private int[] parent;

    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    if (findFather(i) != findFather(j)) {
                        union(i, j);
                    }
                    isConnected[i][j] = 0;
                    isConnected[j][i] = 0;
                }
            }
        }
        Set<Integer> result = new HashSet<>();
        for (int p : parent) {
            result.add(findFather(p));
        }

        return result.size();
    }

    public int findFather(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = findFather(parent[x]);
    }

    public void union(int x, int y) {
        parent[findFather(x)] = findFather(y);
    }

    public static void main(String[] args) {
        int[][] isConn = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        LeetCode547 leetCode547 = new LeetCode547();
        leetCode547.findCircleNum(isConn);
    }
}
