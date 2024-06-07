package leetcode;

/**
 * @author = wangyilin29
 * @date = 2023/12/20
 **/
public class LeetCode2965 {
    public static void main(String[] args) {
        int[][] g = new int[][]{{1, 3}, {2, 2}};
        LeetCode2965 leetCode2965 = new LeetCode2965();
        System.out.println(leetCode2965.findMissingAndRepeatedValues(g));
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int n = grid.length;
        for (int i = 0; i < n * n; i++) {
            result[0] = result[0] ^ i;
            result[1] = result[1] ^ i;
        }


        return result;
    }
}
