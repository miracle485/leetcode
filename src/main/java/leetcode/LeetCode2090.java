package leetcode;

import java.util.Arrays;

public class LeetCode2090 {
    public static int[] getAverages(int[] nums, int k) {
        int[] result = new int[nums.length];
        long[] preSum = new long[nums.length];
        preSum[0] = nums[0];
        result[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
            result[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0 && i + k < nums.length) {
                result[i] = (int) ((preSum[i + k] - (i == k ? 0 : preSum[i - k - 1])) / (2 * k + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(LeetCode2090.getAverages(new int[]{7, 7, 7, 7, 7, 7, 7, 7, 7}, 3)));
    }
}
