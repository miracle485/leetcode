package leetcode;

import java.util.Arrays;

public class LeetCode1005 {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int MIN = 10000;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                result = result - nums[i];
                //nums[i] = -nums[i];
                k--;
                continue;
            }
            if (k != 0) {
                if (i == 0) {
                    result = result + (k % 2 == 0 ? nums[i] : -nums[i]);
                    k = 0;
                    continue;
                }
                int pre = Math.abs(nums[i - 1]);
                if (pre < nums[i]) {
                    result += nums[i];
                    result = result + (k % 2 == 0 ? 0 : -2 * pre);
                } else {
                    result = result + (k % 2 == 0 ? nums[i] : -nums[i]);
                }
                k = 0;
                continue;
            }
            result += nums[i];
        }
        if (k != 0) {
            result = result + (k % 2 == 0 ? 0 : -nums[nums.length - 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode1005.largestSumAfterKNegations(new int[]{-4,-2,-3}, 4));
    }
}
