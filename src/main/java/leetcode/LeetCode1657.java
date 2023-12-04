package leetcode;

import java.util.Arrays;

/**
 * @author = wangyilin29
 * @date = 2023/11/30
 **/
public class LeetCode1657 {
    public static void main(String[] args) {
        LeetCode1657 leetCode1657 = new LeetCode1657();
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            w1[c1[i] - 'a']++;
            w2[c2[i] - 'a']++;
        }
        for (int i = 0; i < w1.length; i++) {
            if (w1[i] == 0 && w2[i] == 0) {
                continue;
            } else if (w1[i] != 0 && w2[i] != 0) {
                continue;
            }
            return false;
        }
        Arrays.sort(w1);
        Arrays.sort(w2);
        for (int i = 0; i < w1.length; i++) {
            if (w1[i] == w2[i]) {
                continue;
            }
            return false;
        }
        return true;
    }
}
