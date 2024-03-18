package leetcode;

import java.util.Arrays;

/**
 * @author = wangyilin29
 * @date = 2023/12/20
 **/
public class LeetCode2967 {
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int minCostNum;
        if (nums.length % 2 == 0) {
            minCostNum = nums[(nums.length) / 2];
        } else {
            minCostNum = (nums[(nums.length) / 2] + nums[(nums.length - 1) / 2]) / 2;
        }
        long result = 0;
        for (int num : nums) {
            result += Math.abs(num - minCostNum);
        }
        return result;
    }
}
