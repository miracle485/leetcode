package leetcode;

public class LeetCode198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
                continue;
            }
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
