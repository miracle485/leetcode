package leetcode;

import java.util.*;

/**
 * @author = wangyilin29
 * @date = 2024/4/12
 **/
public class LeetCode1766 {
    private Map<Integer, List<Integer>> childMap = new HashMap<>();
    private Map<Integer, Integer> dynamic;
    private int[] nums;
    private int[] result;
    private int[][] gcd = new int[51][51];

    public static void main(String[] args) {
        int[] nums = new int[]{9, 16, 30, 23, 33, 35, 9, 47, 39, 46, 16, 38, 5, 49, 21, 44, 17, 1, 6, 37, 49, 15, 23, 46, 38, 9, 27, 3, 24, 1, 14, 17, 12, 23, 43, 38, 12, 4, 8, 17, 11, 18, 26, 22, 49, 14, 9};
        int[][] re = new int[][]{{17, 0}, {30, 17}, {41, 30}, {10, 30}, {13, 10}, {7, 13}, {6, 7}, {45, 10}, {2, 10}, {14, 2}, {40, 14}, {28, 40}, {29, 40}, {8, 29}, {15, 29}, {26, 15}, {23, 40}, {19, 23}, {34, 19}, {18, 23}, {42, 18}, {5, 42}, {32, 5}, {16, 32}, {35, 14}, {25, 35}, {43, 25}, {3, 43}, {36, 25}, {38, 36}, {27, 38}, {24, 36}, {31, 24}, {11, 31}, {39, 24}, {12, 39}, {20, 12}, {22, 12}, {21, 39}, {1, 21}, {33, 1}, {37, 1}, {44, 37}, {9, 44}, {46, 2}, {4, 46}};
        LeetCode1766 leetCode176 = new LeetCode1766();
        leetCode176.getCoprimes(nums, re);
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        int n = nums.length;
        result = new int[n];
        this.nums = nums;
        dynamic = new HashMap<>();
        init(n, edges);

        dfs(0, new ArrayList<>(), new HashMap<>());
        return result;
    }

    private void init(int n, int[][] edges) {
        Map<Integer, List<Integer>> preChildMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            childMap.put(i, new ArrayList<>());
            preChildMap.put(i, new ArrayList<>());
            result[i] = -1;
        }
        for (int[] edge : edges) {
            preChildMap.get(edge[0]).add(edge[1]);
            preChildMap.get(edge[1]).add(edge[0]);
        }
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 50; j++) {
                if (i == j) {
                    gcd[i][j] = i;
                } else {
                    int gcd1 = gcd(i, j);
                    gcd[i][j] = gcd1;
                    gcd[j][i] = gcd1;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        set.add(0);
        int d = 0;
        int nowSize = 1;
        while (!queue.isEmpty()) {
            int currSize = 0;
            while (nowSize > 0) {
                nowSize--;
                Integer poll = queue.poll();
                List<Integer> childList = childMap.get(poll);
                List<Integer> list = preChildMap.get(poll);
                for (Integer now : list) {
                    if (set.contains(now)) {
                        continue;
                    }
                    queue.offer(now);
                    childList.add(now);
                    set.add(now);
                    currSize++;
                }
                dynamic.put(poll, d);
            }
            d++;

            nowSize = currSize;
        }
    }

    private void dfs(int now, List<Integer> parentList, Map<Integer, List<Integer>> countMap) {
        List<Integer> childList = childMap.get(now);
        Set<Integer> gcdList = new HashSet<>();
        for (Integer key : countMap.keySet()) {
            if (gcd[key][nums[now]] == 1) {
                gcdList.add(key);
            }
        }
        int maxD = -1;
        int maxR = Integer.MAX_VALUE;
        for (Integer i : gcdList) {
            List<Integer> list = countMap.get(i);
            if (list.isEmpty()) {
                continue;
            }
            Integer parent = list.get(list.size() - 1);
            if (dynamic.get(parent) > maxD) {
                maxD = dynamic.get(parent);
                maxR = parent;
            }
        }
        if (maxR != Integer.MAX_VALUE) {
            result[now] = maxR;
        }

        parentList.add(now);
        countMap.computeIfAbsent(nums[now], key -> new ArrayList<>()).add(now);
        for (Integer child : childList) {
            dfs(child, parentList, countMap);
        }
        parentList.remove(parentList.size() - 1);
        List<Integer> list = countMap.get(nums[now]);
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            countMap.remove(nums[now]);
        }
    }

    private int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        }
        return gcd(y, x % y);
    }

}
