package leetcode;

import java.util.Arrays;

/**
 * @author = wangyilin29
 * @date = 2023/12/20
 **/
public class LeetCode2966 {
    public int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[nums.length / 3][3];
        int[][] empty = new int[0][0];
        int now = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return empty;
            }
            result[now][0] = nums[i];
            result[now][1] = nums[i + 1];
            result[now][2] = nums[i + 2];
            now++;
        }

        return result;
    }
}
