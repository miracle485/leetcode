package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/3/20
 **/
public class LeetCode1969 {
    public static void main(String[] args) {
        LeetCode1969 leetCode1969 = new LeetCode1969();
        System.out.println(leetCode1969.minNonZeroProduct(31));
    }

    public int minNonZeroProduct(int p) {
        int mod = (int) (1e9 + 7);
        long x = fastPow(2, p, mod);
        long y = fastPow(2, p - 1, mod);
        return (int) ((x - 1) % mod * fastPow(x - 2, y - 1, mod) % mod);
    }

    public int fastPow(long x, long p, int mod) {
        long result = 1;
        while (p > 0) {
            if (p % 2 == 1) {
                result = result * x % mod;
            }
            x = x * x % mod;
            p = p / 2;
        }

        return (int) result;
    }
}
