package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author = wangyilin29
 * @date = 2024/3/25
 **/
public class LeetCode64 {
    private final int[][] direction = new int[][]{{0, 1}, {1, 0}};
    private int m;
    private int n;

    public static void main(String[] args) {
        LeetCode64 leetCode64 = new LeetCode64();
        leetCode64.minPathSum(new int[][]{{7, 1, 3, 5, 8, 9, 9, 2, 1, 9, 0, 8, 3, 1, 6, 6, 9, 5},
                {9, 5, 9, 4, 0, 4, 8, 8, 9, 5, 7, 3, 6, 6, 6, 9, 1, 6},
                {8, 2, 9, 1, 3, 1, 9, 7, 2, 5, 3, 1, 2, 4, 8, 2, 8, 8},
                {6, 7, 9, 8, 4, 8, 3, 0, 4, 0, 9, 6, 6, 0, 0, 5, 1, 4},
                {7, 1, 3, 1, 8, 8, 3, 1, 2, 1, 5, 0, 2, 1, 9, 1, 1, 4},
                {9, 5, 4, 3, 5, 6, 1, 3, 6, 4, 9, 7, 0, 8, 0, 3, 9, 9},
                {1, 4, 2, 5, 8, 7, 7, 0, 0, 7, 1, 2, 1, 2, 7, 7, 7, 4},
                {3, 9, 7, 9, 5, 8, 9, 5, 6, 9, 8, 8, 0, 1, 4, 2, 8, 2},
                {1, 5, 2, 2, 2, 5, 6, 3, 9, 3, 1, 7, 9, 6, 8, 6, 8, 3},
                {5, 7, 8, 3, 8, 8, 3, 9, 9, 8, 1, 9, 2, 5, 4, 7, 7, 7},
                {2, 3, 2, 4, 8, 5, 1, 7, 2, 9, 5, 2, 4, 2, 9, 2, 8, 7},
                {0, 1, 6, 1, 1, 0, 0, 6, 5, 4, 3, 4, 3, 7, 9, 6, 1, 9}});
    }

    public int minPathSum(int[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        m = grid.length;
        n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] cc = new int[m][n];
        int nowS = 1;
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        dp[0][0] = grid[0][0];
        while (!queue.isEmpty()) {
            int newS = 0;
            while (nowS > 0) {
                Point now = queue.poll();
                cc[now.x][now.y] = 1;
                for (int[] p : direction) {
                    int newX = now.x + p[0];
                    int newY = now.y + p[1];
                    if (unValid(newX, newY)) {
                        continue;
                    }

                    if (cc[newX][newY] == 0) {
                        cc[newX][newY] = 1;
                        queue.offer(new Point(newX, newY));
                        newS++;
                    }
                    dp[newX][newY] = Math.min(dp[now.x][now.y] + grid[newX][newY], dp[newX][newY]);
                }

                nowS--;
            }
            nowS = newS;
        }
        return dp[m - 1][n - 1];
    }

    private boolean unValid(int newX, int newY) {
        return newX < 0 || newY < 0 || newX >= m || newY >= n;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
