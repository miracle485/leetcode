package leetcode;

public class LeetCode2981 {
    public int maximumLength(String s) {
        char[] charArray = s.toCharArray();
        char[] zimu = new char[26];
        int result = -1;
        for (char c : charArray) {
            zimu[c - 'a']++;
            if (zimu[c - 'a'] >= 3) {
                result = 1;
            }
        }
        if (result < 0) {
            return result;
        }


        return result;
    }
}
