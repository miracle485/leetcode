package leetcode;

public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int preN = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                preN++;
                continue;
            }
            if (preN != 0) {
                nums[i - preN] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        LeetCode283 leetCode283 = new LeetCode283();
        leetCode283.moveZeroes(nums);
    }
}
