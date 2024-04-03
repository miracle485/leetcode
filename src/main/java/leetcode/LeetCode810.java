package leetcode;

import java.util.*;

public class LeetCode810 {

    public static void main(String[] args) {
        LeetCode810 leetCode810 = new LeetCode810();
        int[] a = new int[]{1, 0};
        leetCode810.xorGame(a);
    }

    public boolean xorGame(int[] nums) {
        int zero = 0;
        for (int num : nums) {
            zero = zero ^ num;
        }


        return zero == 0 || (nums.length % 2 == 0);
    }
}
