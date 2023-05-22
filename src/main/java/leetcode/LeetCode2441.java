package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode2441 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = -1;
        for (int num : nums) {
            if (set.contains(-num) && (Math.abs(num) > result)) {
                result = num;
            }
        }

        return result;
    }
}
