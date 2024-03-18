package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/3/18
 **/
public class LeetCode303 {
    private int[] nums;
    private int[] subSum;

    public void NumArray(int[] nums) {
        this.nums = nums;
        subSum = new int[this.nums.length + 1];
        subSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            subSum[i] = subSum[i - 1] + nums[i];
        }
        subSum[nums.length] = subSum[nums.length - 1];
    }

    public int sumRange(int left, int right) {
        return subSum[right + 1] - subSum[left];
    }
}
