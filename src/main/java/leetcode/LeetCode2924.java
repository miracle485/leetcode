package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2924 {
    public int findChampion(int n, int[][] edges) {
        Map<Integer, List<Integer>> re = new HashMap<>();
        for (int i = 0; i < n; i++) {
            re.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            re.get(edge[1]).add(edge[0]);
        }
        int m = -1;
        for (Map.Entry<Integer, List<Integer>> entry : re.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                continue;
            }
            if (m != -1) {
                return -1;
            }
            m = entry.getKey();
        }
        return m;
    }
}
