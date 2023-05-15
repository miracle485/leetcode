package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int result = 1;
        String[][] number = new String[matrix.length][2];
        Map<String, Integer> sumNumber = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder reverseBuilder = new StringBuilder();
            StringBuilder numberStrBuilder = new StringBuilder();
            for (int j : matrix[i]) {
                reverseBuilder.append(j == 0 ? 1 : 0);
                numberStrBuilder.append(j);
            }
            String numStr = numberStrBuilder.toString();
            String reverse = reverseBuilder.toString();
            number[i][0] = numStr;
            number[i][1] = reverse;

            Integer numSum = sumNumber.get(numStr);
            if (numSum != null) {
                numSum++;
                sumNumber.put(numStr, numSum);
            } else {
                sumNumber.put(numStr, 1);
            }
        }

        for (String[] num : number) {
            int a = sumNumber.getOrDefault(num[0], 0);
            Integer b = sumNumber.get(num[1]);
            if (b != null) {
                a = a + b;
            }
            result = Math.max(result, a);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1}, {1, 0}};
        LeetCode1072 leetCode1072 = new LeetCode1072();
        System.out.println(leetCode1072.maxEqualRowsAfterFlips(matrix));
    }
}
