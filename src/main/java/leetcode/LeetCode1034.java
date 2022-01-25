package leetcode;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Arrays;
import java.util.Queue;

public class LeetCode1034 {
    private static final int[][] FX = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private static int[][] flags, from;

    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        flags = new int[grid.length][grid[0].length];
        from = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            from[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        dfs(grid, row, col, color, grid[row][col]);
        return from;
    }

    public static void dfs(int[][] grid, int row, int col, int color, int preColor) {
        if (flags[row][col] != 0) {
            return;
        }
        flags[row][col] = 1;
        int isZ = 0;
        for (int[] f : FX) {
            int x = row + f[0];
            int y = col + f[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                from[row][col] = color;
                continue;
            }
            if (grid[x][y] == preColor) {
                isZ++;
                dfs(grid, x, y, color, preColor);
            }

        }
        if (isZ < 4) {
            from[row][col] = color;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(LeetCode1034.colorBorder(new int[][]{{1, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 1, 2}, {1, 2, 2, 2, 1, 2}}, 1, 3, 1)));
    }
}
