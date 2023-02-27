package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode2347 {
    public String bestHand(int[] ranks, char[] suits) {
        int c = 1;
        for (int i = 1; i < suits.length; i++) {
            if (suits[i] == suits[i - 1]) {
                c++;
            }
        }
        if (c == 5) {
            return "Flush";
        }
        Map<Integer, Integer> collect = new HashMap<>();
        int max = 0;
        for (int rank : ranks) {
            Integer orDefault = collect.getOrDefault(rank, 0);
            orDefault++;
            max = Math.max(max, orDefault);
            collect.put(rank, orDefault);
        }
        if (max >= 3) {
            return "Three of a Kind";
        }
        if (max == 2) {
            return "Pair";
        }
        return "High Card";
    }
}
