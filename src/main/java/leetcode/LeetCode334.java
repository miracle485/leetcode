package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode334 {
    public static boolean increasingTriplet(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int[] next = new int[nums.length];
        int[] preNum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            next[i] = -1;
            preNum[i]=-1;
        }
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int curr = stack.peek();
            if (nums[i] > nums[curr]) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    int pre = stack.pop();
                    next[pre] = i;
                }
            }
            stack.push(i);
        }
        stack.clear();
        stack.push(nums.length-1);
        for (int i = nums.length-2; i >=0 ; i--) {
            int curr = stack.peek();
            if (nums[i] < nums[curr]) {
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    int pre = stack.pop();
                    preNum[pre] = i;
                }
            }
            stack.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (next[i] != -1 && preNum[i] != -1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode334.increasingTriplet(new int[]{1, 5, 0, 4, 1, 3}));
    }
}
