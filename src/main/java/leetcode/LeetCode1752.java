package leetcode;

public class LeetCode1752 {
    public boolean check(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n * 2; i++) {
            if (nums[i % n] <= nums[(i + 1) % n]) {
                ans++;
            } else {
                ans = 1;
            }
            if (ans == n) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LeetCode1752 leetCode1752 = new LeetCode1752();
        System.out.println(leetCode1752.check(new int[]{3, 4, 5, 1, 2}));
    }
}
