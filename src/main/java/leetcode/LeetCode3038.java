package leetcode;

public class LeetCode3038 {
    public int maxOperations(int[] nums) {
        int result = 0;
        int pre = nums[0] + nums[1];
        for (int i = 0; i < nums.length; i += 2) {
            if (i + 1 >= nums.length) {
                break;
            }
            if (nums[i] + nums[i + 1] == pre) {
                result++;
            }else {
                break;
            }
        }
        return result;
    }
}
