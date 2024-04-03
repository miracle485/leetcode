package leetcode;

import java.util.Arrays;

/**
 * @author = wangyilin29
 * @date = 2024/3/25
 **/
public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        dp[0] = 0;
        Arrays.fill(dp, -1);
        for (int i = 1; i <= amount; i++) {
            int curr = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) {
                    break;
                }
                if (dp[i - coin] == -1) {
                    continue;
                }
                curr = Math.min(dp[i - coin] + 1, curr);
            }
            if (curr != Integer.MAX_VALUE) {
                dp[i] = curr;
            }
        }
        return dp[amount];
    }
}
