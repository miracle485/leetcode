package leetcode;

public class LeetCode1732 {
    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;
        int[] curr = new int[gain.length + 1];
        for (int i = 0; i < gain.length; i++) {
            curr[i + 1] = gain[i] + curr[i];
        }
        for (int num : curr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode1732 leetCode1732 = new LeetCode1732();
        leetCode1732.largestAltitude(new int[]{-5, 1, 5, 0, -7});
    }
}
