package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode1953 {
    public long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        int[] preSum = new int[milestones.length];
        preSum[0] = milestones[0];
        for (int i = 1; i < milestones.length; i++) {
            preSum[i] = preSum[i - 1] + milestones[i];
        }
        return 0;
    }
}
