package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeetCode2225 {
    public static void main(String[] args) {
        int[][] matches = new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}};
        LeetCode2225 leetCode225 = new LeetCode2225();
        leetCode225.findWinners(matches);
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        int[] win = new int[100005];
        int[] lose = new int[100005];
        for (int i = 0; i < win.length; i++) {
            win[i] = -1;
            lose[i] = -1;
        }
        for (int[] match : matches) {
            win[match[0]] = win[match[0]] == -1 ? 1 : win[match[0]] + 1;
            lose[match[0]] = lose[match[0]] == -1 ? 0 : lose[match[0]];
            lose[match[1]] = lose[match[1]] == -1 ? 1 : lose[match[1]] + 1;
            win[match[1]] = win[match[1]] == -1 ? 0 : win[match[1]];

        }
        for (int i = 0; i < win.length; i++) {
            if (lose[i] == 0 && win[i] > 0) {
                result.get(0).add(i);
            }
            if (lose[i] == 1 && win[i] == -1) {
                result.get(1).add(i);
            }
        }
        return result;
    }
}
