package leetcode;

import java.lang.annotation.Target;

/**
 * @author = wangyilin29
 * @date = 2024/3/18
 **/
public class LeetCode2834 {
    public static void main(String[] args) {
        LeetCode2834 leetCode2834 = new LeetCode2834();
        System.out.println(leetCode2834.minimumPossibleSum(63623, 82276));
    }

    public int minimumPossibleSum(int n, int target) {
        long mid = target >> 1;
        int mod = (int) (1e9 + 7);
        if (mid >= n) {
            return (int) (((((long) n) * (n + 1) % mod) / 2) % mod);
        }

        long resultPre = computeSum(mid, mod) + target;

        long end = target + n - mid - 1;
        long sub = computeSum(end, mod) - computeSum(target, mod);
        return (int) ((resultPre + sub) % mod);
    }

    private long computeSum(long n, int mod) {
        return ((n * (n + 1)) / 2 % mod);
    }
}
