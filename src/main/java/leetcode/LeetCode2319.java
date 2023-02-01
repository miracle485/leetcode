package leetcode;

public class LeetCode2319 {
    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if ((i == j || i == grid[j].length - j - 1)) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                    continue;
                }
                if (grid[i][j] == 0) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0, 0, 1}, {0, 4, 0, 1, 0}, {0, 0, 5, 0, 0}, {0, 5, 0, 2, 0}, {4, 0, 0, 0, 2}};
        LeetCode2319 leetCode2319 = new LeetCode2319();
        System.out.println(leetCode2319.checkXMatrix(grid));
    }
}
