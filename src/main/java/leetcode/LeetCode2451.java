package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2451 {
    public String oddString(String[] words) {
        String result = null;
        Map<String, Integer> map = new HashMap<>();
        boolean hasEqual = false;
        int[] firstN = new int[words[0].length() - 1];
        char[] first = words[0].toCharArray();
        for (int i = 0; i < first.length - 1; i++) {
            firstN[i] = first[i + 1] - first[i];
        }
        for (int i = 1; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            boolean isEqual = true;

            for (int j = 0; j < chars.length - 1; j++) {
                if (firstN[j] == (chars[j + 1] - chars[j])) {
                    continue;
                }
                isEqual = false;
                break;
            }
            if (isEqual) {
                hasEqual = true;
            } else {
                result = words[i];
            }
        }

        if (!hasEqual) {
            return words[0];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"adc", "abc", "wzy"};
        LeetCode2451 leetCode2451 = new LeetCode2451();
        leetCode2451.oddString(words);
    }
}
