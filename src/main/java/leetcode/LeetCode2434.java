package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode2434 {
    public static String robotWithString(String s) {
        Deque<Character> deque = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        int[] minChar = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            minChar[(c - 'a')]++;
        }
        int minIndex = 0;
        for (char c : charArray) {
            minChar[c - 'a']--;
            while (minIndex < 26 && minChar[minIndex] == 0) minIndex++;

            deque.offerFirst(c);
            while (!deque.isEmpty() && deque.peekFirst() <= (minIndex + 'a')) {
                builder.append(deque.pollFirst());
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(LeetCode2434.robotWithString("vzhofnpo"));
    }
}
