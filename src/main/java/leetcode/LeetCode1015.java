package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1015 {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int result = 1, s = 1 % k;
        Set<Integer> set = new HashSet<>();
        while (s > 0) {
            s = (s * 10 + 1) % k;
            result++;
            if (set.contains(s)) {
                return -1;
            }
            set.add(s);
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode1015 leetCode1015 = new LeetCode1015();

        System.out.println(leetCode1015.smallestRepunitDivByK(3));
    }
}
