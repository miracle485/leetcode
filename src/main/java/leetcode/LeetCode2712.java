package leetcode;

public class LeetCode2712 {
    public long minimumCost(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                result += Math.min(i, chars.length - i);
            }
        }

        return result;
    }
}
