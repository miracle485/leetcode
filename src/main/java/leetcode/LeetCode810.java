package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode810 {
    private static final Map<Integer, Integer> mapCount = new HashMap<>();

    public boolean xorGame(int[] nums) {

        Arrays.stream(nums).forEach(this::countMap);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : mapCount.entrySet()) {
            if (entry.getValue() %2 == 1) {
                count++;
            }
        }

        return count % 2 != 1;
    }

    private void countMap(int num) {
        Integer orDefault = mapCount.getOrDefault(num, 0);
        orDefault++;
        mapCount.put(num, orDefault);
    }

    public static void main(String[] args) {
        LeetCode810 leetCode810 = new LeetCode810();
        int[] a = new int[]{1, 0};
        leetCode810.xorGame(a);
    }
}
