package leetcode;

/**
 * @author = wangyilin29
 * @date = 2023/12/15
 **/
public class LeetCode1094 {
    public static void main(String[] args) {
        LeetCode1094 leetCode1094 = new LeetCode1094();
        int[][] tr = new int[][]{{2, 1, 5}, {3, 5, 7}};
        int cap = 3;
        System.out.println(leetCode1094.carPooling(tr, cap));
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int[] result = new int[1005];
        for (int[] trip : trips) {
            int from = trip[1];
            int to = trip[2];
            int cap = trip[0];
            result[from] += cap;
            result[to + 1] -= cap;
        }
        int now = 0;
        for (int re : result) {
            now += re;
            if (now > capacity) {
                return false;
            }
        }

        return true;
    }
}
