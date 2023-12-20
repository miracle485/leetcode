package leetcode;

/**
 * @author = wangyilin29
 * @date = 2023/12/18
 **/
public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean pre = false;
            boolean after = false;
            if (i == 0 || nums[i] > nums[i - 1]) {
                pre = true;
            }
            if (i == nums.length - 1 || nums[i] > nums[i + 1]) {
                after = true;
            }
            if (pre & after) {
                return i;
            }
        }
        return -1;
    }
}
