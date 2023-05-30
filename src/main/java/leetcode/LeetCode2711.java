package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Set<Integer> topLeft = new HashSet<>();
                Set<Integer> bottomRight = new HashSet<>();
                int x = i - 1, y = j - 1;
                while (x >= 0 && x < grid.length && y >= 0 && y < grid[i].length) {
                    topLeft.add(grid[x][y]);
                    x--;
                    y--;
                }

                x = i + 1;
                y = j + 1;
                while (x >= 0 && x < grid.length && y >= 0 && y < grid[i].length) {
                    bottomRight.add(grid[x][y]);
                    x++;
                    y++;
                }
                result[i][j] = Math.abs(topLeft.size() - bottomRight.size());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3}, {3, 4, 5}, {3, 2, 3}};
        LeetCode2711 leetCode2711 = new LeetCode2711();
        System.out.println(leetCode2711.differenceOfDistinctValues(grid));
    }
}
