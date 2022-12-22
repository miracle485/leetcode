package leetcode;

public class LeetCode1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long de = Math.abs(sum - goal);
        if (de == 0) {
            return 0;
        }
        int ans = (int)de / limit;
        if (de < limit || de % limit != 0) {
            ans++;
        }
        return ans;
    }
}
