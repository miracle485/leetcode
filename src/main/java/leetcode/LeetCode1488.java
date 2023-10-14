package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LeetCode1488 {
    public int[] avoidFlood(int[] rains) {
        int[] empty = new int[0];
        int[] result = new int[rains.length];
        Map<Integer, Integer> flow = new HashMap<>();
        List<Integer> m = new LinkedList<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                result[i] = 1;
                m.add(i);
                continue;
            }
            result[i] = -1;
            if (!flow.containsKey(rains[i])) {
                flow.put(rains[i], i);
                continue;
            }
            int k = -1;
            int pre = flow.get(rains[i]);
            Iterator<Integer> iterator = m.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next > pre) {
                    k = next;
                    iterator.remove();
                    break;
                }
            }
            if (k == -1) {
                return empty;
            }
            result[k] = rains[i];
            flow.put(rains[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] rains = new int[]{1, 0, 2, 3, 0, 1, 2};
        LeetCode1488 leetCode1488 = new LeetCode1488();
        leetCode1488.avoidFlood(rains);
    }
}
