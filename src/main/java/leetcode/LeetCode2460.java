package leetcode;

public class LeetCode2460 {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
        }

        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for (int num : nums) {
            if (num != 0) {
                result[left++] = num;
            } else {
                result[right--] = num;
            }
        }

        return result;
    }
}
