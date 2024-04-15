package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/4/10
 **/
public class LeetCode1702 {
    public String maximumBinaryString(String binary) {
        char[] charArray = binary.toCharArray();
        StringBuilder result = new StringBuilder();
        int oneCount = 0;
        int zeroCount = 0;
        boolean pre = true;
        for (char c : charArray) {
            if (c != '1') {
                zeroCount++;
                pre = false;
            } else if (!pre) {
                oneCount++;
            }
        }
        pre = true;
        for (char c : charArray) {
            if (c != '1') {
                break;
            }
            result.append('1');
        }
        for (int i = 0; i < zeroCount; i++) {
            if (i + 1 == zeroCount) {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        for (int i = 0; i < oneCount; i++) {
            result.append('1');
        }
        return result.toString();
    }
}
