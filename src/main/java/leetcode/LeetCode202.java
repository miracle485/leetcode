package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode202 {
    /**
     * 哈希
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int result = n;
        while (result != 1 && !set.contains(result)) {
            set.add(result);
            result = getNext(result);
        }


        return result == 1;
    }

    /**
     * 快慢指针
     */

    public boolean testHappy(int n) {
        int l1 = n;
        int l2 = getNext(getNext(n));

        while (l1 != l2) {
            l1 = getNext(l1);
            l2 = getNext(getNext(l2));

        }

        return l1 == 1;
    }

    public int getNext(int result) {
        int curr = result;
        int newV = 0;
        while (curr != 0) {
            newV += (curr % 10) * (curr % 10);
            curr = curr / 10;
        }

        return newV;
    }
}
