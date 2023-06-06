package leetcode;

public class LeetCode2352 {
    public int equalPairs(int[][] grid) {
        int result = 0;
        for (int[] ints : grid) {
            for (int j = 0; j < ints.length; j++) {
                boolean eq = true;
                for (int k = 0; k < ints.length; k++) {
                    if (ints[k] != grid[k][j]) {
                        eq = false;
                        break;
                    }
                }
                if (eq) {
                    result++;
                }
            }
        }

        return  result;
    }
}
