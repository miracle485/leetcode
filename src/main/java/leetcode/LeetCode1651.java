package leetcode;

import java.util.Arrays;

/**
 * @author = wangyilin29
 * @date = 2024/3/20
 **/
public class LeetCode1651 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int result = 0;
        int count = 0;
        for (int i = piles.length - 1; i >= 0; i -= 2) {
            if (count == piles.length) {
                break;
            }
            result += piles[i - 1];
            count += 3;
        }

        return result;
    }
}
