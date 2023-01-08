package leetcode;


import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LeetCode855 {
    TreeSet<Integer> treeSet;
    int count = 0;


    public LeetCode855(int n) {
        treeSet = new TreeSet<>();
        count = n;
    }

    public int seat() {
        if (treeSet.isEmpty()) {
            treeSet.add(0);
            return 0;
        }
        int result = -1;
        int pre = -1;
        int maxValue = Integer.MIN_VALUE;

        for (Integer pos : treeSet) {
            if (pre == -1) {
                pre = pos;
                continue;
            }
            int len = (pos - pre) / 2;

            if (len > maxValue) {
                result = (pos + pre) / 2;
                maxValue = len;
            }
            pre = pos;
        }
        if (treeSet.first() != 0) {
            Integer first = treeSet.first();
            if (first >= maxValue) {
                result = 0;
                maxValue = first;
            }
        }
        if (treeSet.last() != count - 1) {
            int len = (count - 1 - treeSet.last());
            if (len > maxValue) {
                result = count - 1;
            }
        }
        treeSet.add(result);
        return result;
    }

    public void leave(int p) {
        treeSet.remove(p);
    }

    public static void main(String[] args) {
        LeetCode855 leetCode855 = new LeetCode855(8);
        for (int i = 0; i < 3; i++) {
            leetCode855.seat();
        }
        leetCode855.leave(0);
        leetCode855.leave(7);
        for (int i = 0; i < 7; i++) {
            leetCode855.seat();
        }
        leetCode855.leave(0);
        leetCode855.leave(7);
        leetCode855.seat();
    }
}
