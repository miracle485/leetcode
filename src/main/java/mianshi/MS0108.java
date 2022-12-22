package mianshi;

import java.util.HashSet;
import java.util.Set;

public class MS0108 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> line = new HashSet<>();
        Set<Integer> cow = new HashSet<>();
        if (matrix == null || matrix.length == 0) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    line.add(i);
                    cow.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (line.contains(i) || cow.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
