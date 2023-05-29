package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LeetCode1377 {
    private int now = 0;
    private int t;
    private int target;
    private Map<Integer, Set<Integer>> nodeMap;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (edges.length == 0) {
            if (target == 1) {
                return 1.0;
            }

            return 0.0;
        }


        List<Integer> hasD = new ArrayList<>();
        this.t = t;
        this.target = target;

        nodeMap = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> list = nodeMap.computeIfAbsent(edge[0], key -> new HashSet<>());
            list.add(edge[1]);

            Set<Integer> rev = nodeMap.computeIfAbsent(edge[1], key -> new HashSet<>());
            rev.add(edge[0]);
        }
        Queue<Integer> k = new LinkedList<>();
        k.offer(1);
        while (!k.isEmpty()) {
            Integer node = k.poll();
            hasD.add(node);
            Set<Integer> set = nodeMap.get(node);
            for (int i : hasD) {
                set.remove(i);
            }
            set.forEach(k::offer);
        }


        Map<Integer, Double> curr = new HashMap<>();
        k.offer(1);
        curr.put(1, 1D);
        int size = 1;
        while (!k.isEmpty() && t > 0) {
            t--;
            int parentSize = size;
            size = 0;
            while (parentSize > 0) {
                Integer parent = k.poll();
                parentSize--;
                Set<Integer> set = nodeMap.get(parent);

                if (set.isEmpty()) {
                    continue;
                }
                double parentRe = curr.get(parent);

                for (Integer integer : set) {
                    Double child = curr.computeIfAbsent(integer, key -> parentRe * (1.0 / (set.size())));
                    if (integer == target) {
                        if (nodeMap.get(integer).isEmpty() || t == 0) {
                            return child;
                        } else {
                            return 0;
                        }
                    }
                    k.offer(integer);
                    size++;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] edages = new int[][]{{2,1},{3,2},{4,1},{5,3},{6,2},{7,5},{8,7},{9,8},{10,3},{11,10},{12,9},{13,2},{14,6},{15,1},{16,7},{17,3},{18,13},{19,5},{20,5},{21,11},{22,4},{23,20},{24,19},{25,13},{26,3},{27,19},{28,18},{29,8},{30,19},{31,3},{32,31},{33,18},{34,24}};
        LeetCode1377 leetCode1377 = new LeetCode1377();
        System.out.println(leetCode1377.frogPosition(34, edages, 19, 8));
    }


}
