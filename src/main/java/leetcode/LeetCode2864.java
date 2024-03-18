package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/3/13
 **/
public class LeetCode2864 {
    public String maximumOddBinaryNumber(String s) {
        char[] charArray = s.toCharArray();
        int oneCount = 0;
        for (char c : charArray) {
            if (c - '0' == 1) {
                oneCount++;
            }
        }
        StringBuilder result = new StringBuilder();
        int zeroCount = charArray.length - oneCount;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (oneCount > 1) {
                result.append("1");
                oneCount--;
            } else {
                zeroCount--;
                result.append("0");
            }
        }
        return result.append("1").toString();
    }
}
