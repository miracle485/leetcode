package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1090 {
    private static final Comparator<Pair> comparator = (o1, o2) -> o2.value - o1.value;

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            Pair pair = new Pair();
            pair.labels = labels[i];
            pair.value = values[i];
            pairs.add(pair);
        }
        pairs.sort(comparator);
        Map<Integer, Integer> labelMap = new HashMap<>();
        int now = 0, result = 0;
        while (numWanted > 0 && now < values.length) {
            Pair pair = pairs.get(now++);
            Integer labelNum = labelMap.getOrDefault(pair.labels, 0);
            if (labelNum < useLimit) {
                labelNum++;
                result += pair.value;
                labelMap.put(pair.labels, labelNum);
                numWanted--;
            }

        }

        return result;
    }

    private static class Pair {
        int value;
        int labels;
    }

    public static void main(String[] args) {
        int[] values = new int[]{5, 4, 3, 2, 1};
        int[] labels = new int[]{1, 1, 2, 2, 3};
        LeetCode1090 leetCode1090 = new LeetCode1090();
        leetCode1090.largestValsFromLabels(values, labels, 3, 1);
    }
}
