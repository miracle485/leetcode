package leetcode;

public class LeetCode2432 {
    public static int hardestWorker(int n, int[][] logs) {
        int result = 0;
        int pre = 0;
        int maxT = 0;
        for (int[] log : logs) {
            if (log[1] - pre > maxT) {
                result = log[0];
                maxT = log[1] - pre;
            } else if (log[1] - pre == maxT && result > log[0]) {
                result = log[0];
            }
            pre = log[1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] logs = new int[][]{{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        LeetCode2432.hardestWorker(1, logs);
    }
}
