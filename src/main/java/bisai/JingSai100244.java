package bisai;

import java.util.HashMap;
import java.util.Map;

/**
 * @author = wangyilin29
 * @date = 2024/4/7
 **/
public class JingSai100244 {
    private int[] parent;

    public static void main(String[] args) {
        JingSai100244 jingSai100244 = new JingSai100244();
        int n = 9;
        int[][] edges = new int[][]{{0, 4, 7}, {3, 5, 1}, {1, 3, 5}, {1, 5, 1}};
        int[][] query = new int[][]{{0, 4}, {1, 5}, {3, 0}, {3, 3}, {3, 2}, {2, 0}, {7, 7}, {7, 0}};
        jingSai100244.minimumCost(n, edges, query);
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        parent = new int[n];
        int[] result = new int[query.length];
        Map<Integer, Integer> minLenMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        for (int[] edge : edges) {
            Integer start = minLenMap.getOrDefault(find(edge[0]), Integer.MAX_VALUE);
            start = start & edge[2];
            minLenMap.put(find(edge[0]), start);
        }
        for (int i = 0; i < query.length; i++) {
            int[] edge = query[i];
            if (edge[0] == edge[1]) {
                result[i] = 0;
                continue;
            }
            if (find(edge[0]) == find(edge[1])) {
                result[i] = minLenMap.get(find(edge[0]));
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        int result = find(parent[x]);
        if (result != parent[x]) {
            parent[x] = result;
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xP = find(x);
        int yP = find(y);
        if (xP != yP) {
            parent[xP] = parent[yP];
        }
    }

}
