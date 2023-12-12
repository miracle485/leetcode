package leetcode;

import java.util.*;

/**
 * @author = wangyilin29
 * @date = 2023/12/7
 **/
public class LeetCode1466 {
    public static void main(String[] args) {
        int n = 6;
        int[][] conn = new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        LeetCode1466 leetCode1466 = new LeetCode1466();
        System.out.println(leetCode1466.minReorder(n, conn));

    }

    public int minReorder(int n, int[][] connections) {
        int result = 0;
        Map<Integer, List<Integer>> p2p = new HashMap<>();
        Map<Integer, List<Integer>> pfp = new HashMap<>();
        Set<Integer> parent = new HashSet<>();
        for (int[] connection : connections) {
            List<Integer> list1 = p2p.getOrDefault(connection[0], new ArrayList<>());
            List<Integer> list2 = pfp.getOrDefault(connection[1], new ArrayList<>());
            list1.add(connection[1]);
            list2.add(connection[0]);

            p2p.put(connection[0], list1);
            pfp.put(connection[1], list2);
        }
        Queue<Integer> ls = new LinkedList<>();
        ls.offer(0);
        int size = 1;
        while (!ls.isEmpty()) {
            int c = 0;
            while (size > 0) {
                size--;
                Integer node = ls.poll();
                parent.add(node);
                List<Integer> pfpList = pfp.get(node);
                if (pfpList != null) {
                    for (Integer i : pfpList) {
                        if (!parent.contains(i)) {
                            ls.offer(i);
                            c++;
                        }
                    }
                }

                List<Integer> p2pList = p2p.get(node);
                if (p2pList != null) {
                    for (Integer i : p2pList) {
                        if (!parent.contains(i)) {
                            ls.offer(i);
                            result++;
                            c++;
                        }

                    }
                }
            }
            size = c;
        }

        return result;
    }
}
