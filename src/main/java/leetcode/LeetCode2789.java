package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/3/14
 **/
public class LeetCode2789 {
    public long maxArrayValue(int[] nums) {
        long[] dp = new long[nums.length];
        if (nums.length == 1) {
            return nums[0];
        }
        dp[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            if (dp[i] >= nums[i - 1]) {
                dp[i] = dp[i] + nums[i - 1];
                dp[i - 1] = dp[i];
            } else {
                dp[i - 1] = nums[i - 1];
            }
        }
        long result = 0;
        for (long l : dp) {
            result = Math.max(l, result);
        }
        return result;
    }
}
