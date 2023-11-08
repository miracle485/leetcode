package leetcode;

public class LeetCode2609 {
    public int findTheLongestBalancedSubstring(String s) {
        int result = 0;
        if (s.isEmpty()) {
            return result;
        }

        int oneC = 0, zeroC = 0;
        boolean zeroNeedReset = false, oneNeedReset = false;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroC = zeroNeedReset ? 1 : zeroC + 1;
                oneC = oneC > 0 ? oneC - 1 : oneC;
                zeroNeedReset = false;
                oneNeedReset = true;
            }
            if (c == '1') {
                oneC = oneNeedReset ? 1 : oneC + 1;
                result = Math.max(result, Math.min(oneC, zeroC) * 2);
                zeroNeedReset = true;
                oneNeedReset = false;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode2609 leetCode2609 = new LeetCode2609();
        System.out.println(leetCode2609.findTheLongestBalancedSubstring("111001"));
    }
}
