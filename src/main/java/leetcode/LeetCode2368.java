package leetcode;

import java.util.*;

/**
 * @author = wangyilin29
 * @date = 2024/3/29
 **/
public class LeetCode2368 {
    private Map<Integer, List<Integer>> pointMap;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        pointMap = new HashMap<>();
        for (int[] edge : edges) {
            addEdge(edge);
        }
        int[] done = new int[n];
        for (int i : restricted) {
            done[i] = 1;
        }
        done[0] = 1;
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            List<Integer> ed = pointMap.getOrDefault(poll, new ArrayList<>());
            for (Integer k : ed) {
                if (done[k] == 0) {
                    result++;
                    done[k] = 1;
                    queue.offer(k);
                }
            }
        }
        return result;
    }

    public void addEdge(int[] edge) {
        pointMap.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
        pointMap.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
    }
}
