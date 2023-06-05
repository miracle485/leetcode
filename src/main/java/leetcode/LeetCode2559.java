package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] result = new int[queries.length];
        int[] pre = new int[words.length];
        Set<Character> k = new HashSet<>();
        k.add('a');
        k.add('e');
        k.add('i');
        k.add('o');
        k.add('u');
        int index = 0;
        for (String word : words) {
            char[] chars = word.toCharArray();
            if (index != 0) {
                pre[index] = pre[index] + pre[index - 1];
            }
            if (k.contains(chars[0]) && k.contains(chars[chars.length - 1])) {
                pre[index]++;
            }
            index++;
        }

        index = 0;
        for (int[] query : queries) {
            int sum = 0;
            if (query[0] == 0) {
                sum = pre[query[1]];
            } else {
                sum = pre[query[1]] - pre[query[0] - 1];
            }

            result[index++] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] queries = new int[][]{{0, 2}, {1, 4}, {1, 1}};
        String[] words = new String[]{"aba", "bcb", "ece", "aa", "e"};
        LeetCode2559 leetCode2559 = new LeetCode2559();
        leetCode2559.vowelStrings(words, queries);
    }
}
