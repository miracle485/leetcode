package leetcode;

import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> c = new HashSet<>();
        int[] result = new int[2];
        int all = grid.length * grid.length;
        for (int i = 1; i <= all; i++) {
            c.add(i);
        }
        for (int[] ints : grid) {
            for (int j = 0; j < grid.length; j++) {
                if (c.contains(ints[j])) {
                    c.remove(ints[j]);
                    continue;
                }
                result[0] = ints[j];
            }
        }
        result[1] = c.toArray(new Integer[0])[0];
        return result;
    }
}
