package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/3/29
 **/
public class LeetCode2908 {
    public static void main(String[] args) {
        LeetCode2908 leetCode2908 = new LeetCode2908();
        System.out.println(leetCode2908.minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
    }

    public int minimumSum(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] && nums[k] < nums[j]) {
                        result = Math.min(result, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
