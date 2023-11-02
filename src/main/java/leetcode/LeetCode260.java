package leetcode;

public class LeetCode260 {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }
        int mask = xor & (-xor);
        for (int num : nums) {
            if ((num & mask) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }
}
