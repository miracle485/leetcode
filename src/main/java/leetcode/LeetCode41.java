package leetcode;

/**
 * @author = wangyilin29
 * @date = 2023/12/14
 **/
public class LeetCode41 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, -1, 1};
        LeetCode41 leetCode41 = new LeetCode41();
        System.out.println(leetCode41.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] < nums.length) {
                int c = nums[i];
                int k = nums[c];
                nums[i] = k;
                nums[c] = c;
            }
        }
        Integer result = null;
        for (int i = 1; i < nums.length; i++) {
            if (i == nums[i]) {
                continue;
            }
            result = i;
            break;
        }
        if (result == null) {
            result = nums.length;
        }

        return result;
    }
}
