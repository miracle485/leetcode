package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/3/22
 **/
public class LeetCode3014 {
    public int minimumPushes(String word) {
        int length = word.length();
        int c = 1;
        int result = 0;
        while (length > 0) {
            if (length >= 8) {
                result += 8 * c;
            } else {
                result += (length % 8) * c;
            }
            c++;
            length -= 8;
        }
        return result;

    }
}
