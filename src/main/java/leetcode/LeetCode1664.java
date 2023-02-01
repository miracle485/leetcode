package leetcode;

public class LeetCode1664 {
    public int waysToMakeFair(int[] nums) {
        int[] odd = new int[nums.length];
        int[] even = new int[nums.length];
        even[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) {
                even[i] = even[i - 1] + nums[i];
                odd[i] = odd[i - 1];
            } else {
                odd[i] = odd[i - 1] + nums[i];
                even[i] = even[i - 1];
            }
        }
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                int a = even[n - 1] - even[0];
                result = a == odd[n - 1] ? result + 1 : result;
                continue;
            }
            int a, b, c, d;
            a = even[n - 1] - even[i];
            b = even[i];
            c = odd[n - 1] - odd[i];
            d = odd[i];
            if (i % 2 == 0) {
                b = b - nums[i];
            } else {
                d = d - nums[i];
            }

            if (a + d == b + c) {
                result++;
            }
        }
        return result;
    }
}
