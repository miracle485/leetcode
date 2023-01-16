package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> keyValueMap = new HashMap<>();
        List<String> values = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (List<String> keyValue : knowledge) {
            keyValueMap.put(keyValue.get(0), keyValue.get(1));
        }
        StringBuilder builder = new StringBuilder();
        int left = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                left = i;
                //builder.append(chars[i]);
                continue;
            }
            if (left != -1 && chars[i] != ')') {
                builder.append(chars[i]);
            }
            if (left == -1) {
                result.append(chars[i]);
            }
            if (chars[i] == ')') {
                left = -1;
                //builder.append(chars[i]);
                result.append(keyValueMap.getOrDefault(builder.toString(), "?"));
                builder = new StringBuilder();
            }
        }

        return s;
    }

    public static void main(String[] args) {
        LeetCode1807 leetCode1807 = new LeetCode1807();
        List<List<String>> lists = new ArrayList<>();
        List<String> s1 = new ArrayList<>();
        lists.add(Arrays.asList("a", "b"));
        //lists.add(Arrays.asList("age", "two"));
        leetCode1807.evaluate("hi(name)", lists);
    }
}
