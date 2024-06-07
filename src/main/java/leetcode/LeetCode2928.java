package leetcode;

public class LeetCode2928 {
    public static void main(String[] args) {
        LeetCode2928 leetCode2928 = new LeetCode2928();
        System.out.println(leetCode2928.distributeCandies(5, 2));
    }

    public long distributeCandies(int n, int limit) {

        return cp(n + 2L) - (3 * (cp(n + 2 -  (limit + 1))) - 3 * (cp(n + 2 - 2 * (limit + 1))) + cp(n + 2 - 3 * (limit + 1)));
    }

    private long cp(long n) {
        if (n <= 0) {
            return 0;
        }
        return n * (n - 1) / 2;
    }
}
