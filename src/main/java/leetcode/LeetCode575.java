package leetcode;

import java.util.Arrays;

public class LeetCode575 {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int result = 0;
        int pre = Integer.MAX_VALUE;
        for (int type : candyType) {
            if (type == pre) {
                continue;
            }
            result++;
            if (result >= candyType.length / 2) {
                break;
            }
            pre = type;
        }

        return result;
    }
}
