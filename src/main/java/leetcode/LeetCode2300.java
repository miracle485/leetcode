package leetcode;

import java.util.Arrays;

public class LeetCode2300 {
    private long success;
    private int[] potions;

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        this.success = success;
        int[] result = new int[spells.length];
        if (potions.length == 0) {
            return result;
        }
        Arrays.sort(potions);
        this.potions = potions;

        for (int i = 0; i < spells.length; i++) {
            int index = findBetterThenSuccess(spells[i]);
            if ((long) potions[index] * spells[i] >= success) {
                result[i] = potions.length - index;
            } else {
                result[i] = 0;
            }
        }


        return result;

    }

    public int findBetterThenSuccess(int sp) {
        int left = 0, right = potions.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if ((long) potions[mid] * sp >= success) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] sp = new int[]{5, 1, 3};
        int[] po = new int[]{1, 2, 3, 4, 5};
        long success = 7;
        LeetCode2300 leetCode2300 = new LeetCode2300();

        leetCode2300.successfulPairs(sp, po, 7);
    }
}
