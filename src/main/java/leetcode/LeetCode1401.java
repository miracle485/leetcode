package leetcode;

import java.util.Arrays;

public class LeetCode1401 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int s = 0;
        int result = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            s += satisfaction[i];
            if (s <= 0) {
                break;
            }

            result += s;
        }
        return result;
    }
}
