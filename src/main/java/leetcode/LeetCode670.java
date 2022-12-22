package leetcode;

public class LeetCode670 {
    public int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        char[] numChar = numStr.toCharArray();
        StringBuilder result = new StringBuilder();
        int start = -1;
        int end = -1;
        for (int i = 0; i < numChar.length; i++) {
            char curr = 0;
            for (int j = i + 1; j < numChar.length; j++) {
                if (numChar[j] > numChar[i] && numChar[j] > curr) {
                    curr = numChar[j];
                    start = i;
                    end = j;
                }
            }
            if (start != -1) {
                break;
            }
        }
        if (start == -1) {
            return num;
        }
        for (int i = 0; i < numChar.length; i++) {
            if (i == start) {
                result.append(numChar[end]);
            } else if (i == end) {
                result.append(numChar[start]);
            } else {
                result.append(numChar[i]);
            }
        }
        return Integer.parseInt(result.toString());
    }
}
