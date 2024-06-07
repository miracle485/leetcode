package leetcode;

import java.util.Arrays;

public class LeetCode2028 {
    public static void main(String[] args) {
        int[] rolls = new int[]{4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5};
        int mean = 4;
        int n = 40;
        LeetCode2028 leetCode2028 = new LeetCode2028();
        leetCode2028.missingRolls(rolls, mean, n);
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (n + m);
        int resultLength = n;
        for (int roll : rolls) {
            sum -= roll;
        }
        int[] result = new int[resultLength];
        if (n * 6 < sum || n > sum) {
            return new int[0];
        }
        Arrays.fill(result, sum / resultLength);
        if (sum % resultLength != 0) {
            sum = sum % resultLength;
            int now = 0;
            int c = 6 - result[0];
            while (sum > 0) {
                int add = Math.min(sum, c);
                result[now++] += add;
                sum -= c;
            }
        }

        return result;
    }
}
