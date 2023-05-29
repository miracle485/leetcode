package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                numList.add(nums[i] + nums[j]);
            }
        }
        numList.sort(Comparator.naturalOrder());

        return 0;

    }
}
