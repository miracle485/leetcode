package leetcode;

import java.util.Arrays;

public class LeetCode2644 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int result = -1;
        int max = -1;
        Arrays.sort(divisors);
        for (int i = 0; i < divisors.length; i++) {
            int curr = 0;
            for (int num : nums) {
                if (num % divisors[i] == 0) {
                    curr++;
                }
            }
            if (curr > max) {
                result = i;
                max = curr;
            }
        }
        return result;
    }
}
