package leetcode;

public class LeetCode2710 {
    public String removeTrailingZeros(String num) {
        int zeroNum = 0;
        char[] chars = num.toCharArray();
        while (chars[chars.length - zeroNum - 1] == '0') {
            zeroNum++;
        }
        return num.substring(0, num.length() - zeroNum);
    }
}
