package leetcode;

public class LeetCode1326 {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[ranges.length];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] > i) {
                dp[0] = Math.max(dp[0], i + ranges[i]);
            } else {
                dp[i - ranges[i]] = Math.max(dp[i - ranges[i]], i + ranges[i]);
            }
        }
        return 0;
    }
}
