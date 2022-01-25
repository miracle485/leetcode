package leetcode;

import java.util.Arrays;

public class LeetCode739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int n = temperatures.length;
        if (n == 1) {
            return result;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (temperatures[i] < temperatures[i + 1]) {
                result[i] = 1;
            } else {
                int sum = 1;
                while (((i + sum) < n) && temperatures[i] >= temperatures[i + sum] && result[i + sum] != 0) {
                    sum += result[i + sum];
                }
                if ((i + sum) >= n || temperatures[i + sum] <= temperatures[i]) {
                    result[i] = 0;
                } else {
                    result[i] = sum;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(LeetCode739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
