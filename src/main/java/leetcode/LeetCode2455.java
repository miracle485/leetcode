package leetcode;

public class LeetCode2455 {
    public int averageValue(int[] nums) {
        int sum = 0;
        int n = 0;
        for (int num : nums) {
            if (num % 2 != 0 || num % 3 != 0) {
                continue;
            }
            sum += num;
            n++;
        }
        if (sum == 0) {
            return 0;
        }
        return sum / n;
    }
}
