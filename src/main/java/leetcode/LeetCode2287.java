package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2287 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = countMap.computeIfAbsent(c, key -> 0);
            count++;
            countMap.put(c, count);
        }
        Map<Character, Integer> targetMap = new HashMap<>();
        int minCount = Integer.MAX_VALUE;
        for (char c : target.toCharArray()) {
            Integer count = targetMap.computeIfAbsent(c, key -> 0);
            count++;
            targetMap.put(c, count);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : targetMap.entrySet()) {
            minCount = Math.min(minCount, countMap.getOrDefault(characterIntegerEntry.getKey(), 0) / characterIntegerEntry.getValue());
        }
        return minCount;
    }
}
