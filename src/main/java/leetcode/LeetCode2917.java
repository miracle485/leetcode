package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/3/6
 **/
public class LeetCode2917 {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 12, 9, 8, 9, 15};
        LeetCode2917 leetCode2917 = new LeetCode2917();
        leetCode2917.findKOr(nums, 4);
    }

    public int findKOr(int[] nums, int k) {
        int result = 0;
        int c = 1;
        for (int i = 0; i < 31; i++) {
            int m = c;
            int kc = 0;
            for (int num : nums) {
                if (m == (num & m)) {
                    kc++;
                }
            }
            c = c * 2;
            if (kc >= k) {
                result += m;
            }
        }

        return result;
    }
}
