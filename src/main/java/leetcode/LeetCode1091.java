package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1091 {
    private static final int[][] direction = new int[][]{{0, 1}, {1, 0}, {1, 1}, {0, -1}, {-1, 0}, {-1, -1}, {1, -1}, {-1, 1}};
    private static boolean[][] hasD;
    private static int n;

    public static void main(String[] args) {
        LeetCode1091 leetCode1091 = new LeetCode1091();
        System.out.println(leetCode1091.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        hasD = new boolean[grid.length][grid[0].length];
        n = grid.length;

        Queue<Integer[]> queue = new LinkedList<>();
        if (grid[0][0] != 1) {
            queue.offer(new Integer[]{0, 0});
        }
        int nowSize = 1;
        int[][] dis = new int[n][n];
        for (int[] di : dis) {
            Arrays.fill(di, Integer.MAX_VALUE / 2);
        }
        dis[0][0] = 1;
        while (!queue.isEmpty()) {
            int newSize = 0;
            while (nowSize > 0) {
                nowSize--;
                Integer[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                hasD[x][y] = true;
                for (int[] dir : direction) {
                    if (x + dir[0] < 0 || x + dir[0] >= n) {
                        continue;
                    }
                    if (y + dir[1] < 0 || y + dir[1] >= n) {
                        continue;
                    }
                    if (grid[x + dir[0]][y + dir[1]] == 1) {
                        continue;
                    }
                    dis[x + dir[0]][y + dir[1]] = Math.min(dis[x + dir[0]][y + dir[1]], dis[x][y] + 1);
                    if (!hasD[x + dir[0]][y + dir[1]]) {
                        hasD[x + dir[0]][y + dir[1]] = true;
                        newSize++;
                        queue.offer(new Integer[]{x + dir[0], y + dir[1]});
                    }
                }
            }
            nowSize = newSize;
        }
        if (!hasD[n - 1][n - 1]) {
            return -1;
        }
        return dis[n - 1][n - 1];
    }
}
