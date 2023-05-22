package leetcode;

public class LeetCode1335 {
    private int[] jobD;
    private int d;

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (jobDifficulty.length < d) {
            return -1;
        }
        jobD = jobDifficulty;
        this.d = d;

        return 1;
    }



}
