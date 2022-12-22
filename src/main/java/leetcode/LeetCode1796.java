package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode1796 {
    public int secondHighest(String s) {
        Set<Integer> nums = new HashSet<>();
        if (s == null || s.length() <= 1) {
            return -1;
        }
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                int cNum = c - '0';
                nums.add(cNum);
            }
        }
        if (nums.size() <= 1) {
            return -1;
        }
        List<Integer> zz = new ArrayList<>(nums);
        return zz.get(zz.size() - 2);
    }

    public static void main(String[] args) {
        LeetCode1796 leetCode1796 = new LeetCode1796();
        System.out.println(leetCode1796.secondHighest("ck077"));
    }
}
