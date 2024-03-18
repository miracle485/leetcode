package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/3/7
 **/
public class LeetCode2575 {
    public int[] divisibilityArray(String word, int m) {
        char[] charArray = word.toCharArray();
        int[] result = new int[charArray.length];
        long c = 0;
        for (int i = 0; i < charArray.length; i++) {
            int num = charArray[i] - '0';
            c = (c * 10 + num) % m;
            if (c == 0) {
                result[i] = 1;
            }
        }

        return result;
    }
}
