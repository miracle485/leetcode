package leetcode;

import java.util.Arrays;

public class LeetCode1995 {
    public static int countQuadruplets(int[] nums) {
        //Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                for (int k = j + 1; k < nums.length - 1; k++) {
                    for (int h = k + 1; h < nums.length; h++) {
                        if (nums[i] + nums[j] + nums[k] == nums[h]) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode1995.countQuadruplets(new int[]{28, 8, 49, 85, 37, 90, 20, 8}));
    }
}
