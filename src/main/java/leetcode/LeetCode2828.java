package leetcode;

import java.util.List;

/**
 * @author = wangyilin29
 * @date = 2023/12/20
 **/
public class LeetCode2828 {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            builder.append(word.toCharArray()[0]);
        }
        return builder.toString().equals(s);
    }
}
