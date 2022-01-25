package leetcode;

public class LeetCode747 {
    public static int dominantIndex(int[] nums) {
        int maxNumPos = 0;
        int doub = nums.length-1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxNumPos]) {
                maxNumPos = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (maxNumPos == i) {
                continue;
            }
            if (nums[i] * 2 <= nums[maxNumPos]) {
                doub--;
            }
        }
        return doub == 0 ? maxNumPos : -1;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode747.dominantIndex(new int[]{1, 2, 3, 4}));
    }
}
