package leetcode;

public class LeetCode775 {
    public boolean isIdealPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                if (nums[i] > nums[i + 1]) {
                    if (nums[i] - nums[i + 1] != 1) {
                        return false;
                    }
                }
            }
        }


        return true;
    }

    public static void main(String[] args) {
        LeetCode775 leetCode775 = new LeetCode775();
        System.out.println(leetCode775.isIdealPermutation(new int[]{0, 1}));
    }
}
