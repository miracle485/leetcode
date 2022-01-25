package moban;

import java.util.Stack;

/**
 * 单调栈
 */
public class MonotonicStack {
    public int[] nextGreaterElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (stack.empty() || nums[i] <= nums[stack.peek()]) {
                stack.push(i);
                continue;
            }
            while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                int curr = stack.pop();
                result[curr] = result[i];
            }
            stack.push(i);
        }
        return result;
    }
}
