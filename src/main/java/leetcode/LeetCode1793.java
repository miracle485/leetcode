package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author = wangyilin29
 * @date = 2024/3/19
 **/
public class LeetCode1793 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 5, 4, 5, 4, 1, 1, 1};
        int k = 0;
        LeetCode1793 leetCode1793 = new LeetCode1793();
        System.out.println(leetCode1793.maximumScore(nums, k));
    }

    public int maximumScore(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Deque<Integer> leftDe = new LinkedList<>();

        leftDe.push(nums.length - 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            while (!leftDe.isEmpty() && nums[leftDe.peek()] > nums[i]) {
                Integer pop = leftDe.pop();
                left[pop] = i + 1;
            }
            leftDe.push(i);
        }
        while (!leftDe.isEmpty()) {
            Integer pop = leftDe.pop();
            left[pop] = 0;
        }


        Deque<Integer> rightDe = new LinkedList<>();

        rightDe.push(0);
        for (int i = 0; i < nums.length; i++) {
            while (!rightDe.isEmpty() && nums[rightDe.peek()] > nums[i]) {
                Integer pop = rightDe.pop();
                right[pop] = i - 1;
            }
            rightDe.push(i);
        }
        while (!rightDe.isEmpty()) {
            Integer pop = rightDe.pop();
            right[pop] = nums.length - 1;
        }


        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            int h = nums[i];
            int l = left[i];
            int r = right[i];
            if (l <= k && r >= k) {
                result = Math.max(result, h * (r - l + 1));
            }
        }
        return result;
    }
}
