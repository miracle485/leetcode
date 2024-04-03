package leetcode;

import java.util.Arrays;

/**
 * @author = wangyilin29
 * @date = 2024/3/25
 **/
public class LeetCode518 {
    public static void main(String[] args) {
        LeetCode518 leetCode518 = new LeetCode518();
        leetCode518.change(5, new int[]{2, 1, 5});
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i < coin) {
                    continue;
                }
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}
