package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode2434 {
    public static String robotWithString(String s) {
        StringBuilder sb = new StringBuilder();
        int minIndex = 0;
        char[] charArray = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        stack.push(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {

        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(LeetCode2434.robotWithString("vzhofnpo"));
    }
}
