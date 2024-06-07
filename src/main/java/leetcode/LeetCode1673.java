package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1673 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 3, 3, 5, 4, 9, 6};
        int k = 4;
        LeetCode1673 leetCode1673 = new LeetCode1673();
        System.out.println(Arrays.toString(leetCode1673.mostCompetitive(nums, k)));
    }

    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && (nums[deque.getFirst()] > nums[i]) && (deque.size() + nums.length - i > k)) {
                deque.poll();
            }
            deque.offerFirst(i);
        }
        for (int i = 0; i < k; i++) {
            result[i] = nums[deque.pollLast()];
        }


        return result;
    }
}
