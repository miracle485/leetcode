package leetcode;

public class LeetCode1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        return 0;
    }
}
