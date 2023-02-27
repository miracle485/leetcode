package leetcode;

import java.util.Arrays;

public class LeetCode2357 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int ans = 0;
        int x = 0;
        int sum = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (num - sum <= 0) {
                continue;
            }
            sum += num - sum;
            ans++;
            if (x >= max - sum) {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LeetCode2357 leetCode2357 = new LeetCode2357();
        System.out.println(leetCode2357.minimumOperations(new int[]{1,5,0,3,5}));
    }
}
