package leetcode;

/**
 * @author = wangyilin29
 * @date = 2023/12/13
 **/
public class LeetCode2697 {
    public static void main(String[] args) {
        LeetCode2697 leetCode2697 = new LeetCode2697();
        String s = "egcfe";
        leetCode2697.makeSmallestPalindrome(s);
    }

    public String makeSmallestPalindrome(String s) {
        char[] res = s.toCharArray();
        int left = 0, right = res.length - 1;
        while (left < res.length && right >= 0) {
            if (res[left] == res[right] || left < right) {
                left++;
                right--;
                continue;
            }
            if (res[left] > res[right]) {
                res[left] = res[right];
            } else {
                res[right] = res[left];
            }
            left++;
            right--;
        }

        return String.valueOf(res);
    }
}
