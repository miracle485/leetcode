package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/4/12
 **/
public class LeetCode2923 {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int now = 0;
        for (int i = 1; i < n; i++) {
            if (grid[i][now] == 1) {
                now = i;
            }
        }
        return now;
    }
}
