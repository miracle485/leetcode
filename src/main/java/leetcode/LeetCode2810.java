package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/4/1
 **/
public class LeetCode2810 {
    public String finalString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : charArray) {
            if (c == 'i') {
                result.reverse();
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
