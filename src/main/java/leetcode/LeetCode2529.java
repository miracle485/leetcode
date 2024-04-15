package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/4/9
 **/
public class LeetCode2529 {
    public int maximumCount(int[] nums) {
        int p = 0, r = 0;
        for (int num : nums) {
            if (num > 0) {
                p++;
            } else if (num < 0) {
                r++;
            }
        }
        return Math.max(p, r);
    }
}
