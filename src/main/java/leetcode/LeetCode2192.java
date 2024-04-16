package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author = wangyilin29
 * @date = 2024/4/9
 **/
public class LeetCode2192 {
    public static void main(String[] args) {
        int n = 9;
        int[][] edges = new int[][]{{8, 3}, {6, 3}, {1, 6}, {7, 0}, {8, 5}, {2, 1}, {4, 0}, {2, 3}, {0, 3}, {5, 3}, {7, 4}, {4, 1}};
        LeetCode2192 leetCode2192 = new LeetCode2192();
        leetCode2192.getAncestors(n, edges);
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Set<Integer>> result = new ArrayList<>(n);
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result.add(new HashSet<>(n));
            map.put(i, new ArrayList<>());
            edgeMap.put(i, new HashSet<>());
        }
        List<int[]> collect = Arrays.stream(edges).sorted(Comparator.comparing(edge -> edge[0])).collect(Collectors.toList());
        for (int[] edge : collect) {
            map.get(edge[0]).add(edge[1]);
            result.get(edge[1]).add(edge[0]);
            edgeMap.get(edge[1]).add(edge[0]);
        }
        List<List<Integer>> finalResult = new ArrayList<>();
        boolean[] done = new boolean[n];
        while (true) {
            List<Integer> queue = new LinkedList<>();
            for (int i = 0; i < result.size(); i++) {
                Set<Integer> edge = edgeMap.get(i);
                if (edge.isEmpty() && !done[i]) {
                    done[i] = true;
                    queue.add(i);
                }
            }

            if (queue.isEmpty()) {
                break;
            }

            for (Integer i : queue) {
                List<Integer> list = map.get(i);
                for (Integer child : list) {
                    result.get(child).addAll(result.get(i));
                    edgeMap.get(child).remove(i);
                }
            }
        }
        for (Set<Integer> set : result) {
            finalResult.add(new ArrayList<>(set));
        }
        return finalResult;
    }

}
