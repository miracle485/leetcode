package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, List<Integer>> numSet = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target - nums[i] && numSet.get(nums[i]).size() != 1) {
                result[0] = numSet.get(nums[i]).get(0);
                result[1] = numSet.get(nums[i]).get(1);
                return result;
            }

            if (nums[i] != target - nums[i] && numSet.containsKey(target - nums[i])) {
                result[0] = numSet.get(nums[i]).get(0);
                result[1] = numSet.get(target - nums[i]).get(0);
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        LeetCode1 leetCode1 = new LeetCode1();
        leetCode1.twoSum(nums, 6);
    }
}
