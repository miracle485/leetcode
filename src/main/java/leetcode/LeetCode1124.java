package leetcode;

import java.util.Stack;

public class LeetCode1124 {
    public static void main(String[] args) {
        LeetCode1124 leetCode1124 = new LeetCode1124();
        System.out.println(leetCode1124.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
    }

    public int longestWPI(int[] hours) {
        int[] sum = new int[hours.length + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i <= hours.length; i++) {
            if (hours[i - 1] > 8) {
                sum[i] = sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1] - 1;
            }
            if (sum[i] < sum[stack.peek()]) {
                stack.push(i);
            }
        }
        int result = 0;
        for (int i = sum.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && sum[i] > sum[stack.peek()]) {
                result = Math.max(result, i - stack.pop());
            }
        }

        return result;
    }


}
