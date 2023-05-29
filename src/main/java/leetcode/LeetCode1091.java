package leetcode;

public class LeetCode1091 {
    private static final int[][] direction = new int[][]{{0, 1}, {1, 0}, {1, 1}, {0, -1}, {-1, 0}, {-1, -1}, {1, -1}, {-1, 1}};
    private static int[][] hasD;
    private static int n;

    public int shortestPathBinaryMatrix(int[][] grid) {
        hasD = new int[grid.length][grid[0].length];
        n = grid.length;

        return dfs(0, 0, grid);
    }

    private int dfs(int x, int y, int[][] grid) {
        if (x == n - 1 && y == n - 1) {
            return 0;
        }
        if (hasD[x][y] == 1) {
            return -1;
        }

        int minL = Integer.MAX_VALUE;
        for (int[] dir : direction) {
            if (x + dir[0] < 0 || x + dir[0] >= n) {
                continue;
            }
            if (y + dir[1] < 0 || y + dir[1] >= n) {
                continue;
            }
            if (grid[x + dir[0]][y + dir[1]] == 0) {
                hasD[x][y] = 1;
                int len = dfs(x + dir[0], y + dir[1], grid);
                if (len != -1) {
                    minL = Math.min(minL, len + 1);
                }
                hasD[x][y] = 0;
            }

        }
        if (minL == Integer.MAX_VALUE) {
            return -1;
        }

        return minL;
    }

}
