package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author = wangyilin29
 * @date = 2024/3/21
 **/
public class LeetCode2671 {
    private Map<Integer, Integer> tracker;
    private Map<Integer, Set<Integer>> freq;

    public void FrequencyTracker() {
        tracker = new HashMap<>();
        freq = new HashMap<>();
    }

    public void add(int number) {
        if (!tracker.containsKey(number)) {
            tracker.put(number, 1);
            freq.computeIfAbsent(1, (key) -> new HashSet<>()).add(number);
        } else {
            Integer newValue = tracker.compute(number, (key, value) -> value + 1);
            freq.computeIfAbsent(newValue - 1, (key) -> new HashSet<>()).remove(number);
            freq.computeIfAbsent(newValue, (key) -> new HashSet<>()).add(number);
        }

    }

    public void deleteOne(int number) {
        Integer newValue = tracker.computeIfPresent(number, (key, old) -> {
            old = old - 1;
            if (old <= 0) {
                return null;
            }
            return old;
        });
        if (newValue == null) {
            freq.computeIfAbsent(1, (key) -> new HashSet<>()).remove(number);
        } else {
            freq.computeIfAbsent(newValue + 1, (key) -> new HashSet<>()).remove(number);
            freq.computeIfAbsent(newValue, (key) -> new HashSet<>()).add(number);
        }
    }

    public boolean hasFrequency(int frequency) {
        return !freq.getOrDefault(frequency, new HashSet<>()).isEmpty();
    }
}
