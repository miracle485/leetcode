package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> keyMap = new HashMap<>();
        int f = 0;
        for (char c : key.toCharArray()) {
            if (keyMap.containsKey(c) || ' ' == c) {
                continue;
            }
            char k = (char) ('a' + f);
            keyMap.put(c, k);
            f++;
        }
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                result.append(c);
                continue;
            }
            result.append(keyMap.get(c));
        }
        return result.toString();
    }
}
