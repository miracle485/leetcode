package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class LeetCode503 {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] result = new int[nums.length];
        for (int i=0;i<n;i++){
            result[i]=-1;
        }
        for (int i = 0; i < nums.length * 2; i++) {
            if (stack.empty() || nums[i % n] <= nums[stack.peek()]) {
                stack.push(i % n);
                continue;
            }
            while (!stack.empty() && nums[i % n] > nums[stack.peek()]) {
                int curr = stack.pop();
                result[curr] = nums[i%n];
            }
            stack.push(i % n);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(LeetCode503.nextGreaterElements(new int[]{0,-2,-3})));
    }
}
