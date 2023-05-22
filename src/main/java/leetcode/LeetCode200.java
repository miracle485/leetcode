package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode200 {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    Queue<Integer> bfsQueueX = new LinkedList<>();
                    Queue<Integer> bfsQueueY = new LinkedList<>();
                    bfsQueueX.add(i);
                    bfsQueueY.add(j);
                    while (!bfsQueueX.isEmpty()) {

                        Integer x = bfsQueueX.poll();
                        Integer y = bfsQueueY.poll();
                        if (grid[x][y]=='0'){
                            continue;
                        }
                        grid[x][y] = '0';
                        if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                            bfsQueueX.add(x + 1);
                            bfsQueueY.add(y);
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            bfsQueueX.add(x - 1);
                            bfsQueueY.add(y);
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            bfsQueueX.add(x);
                            bfsQueueY.add(y - 1);
                        }
                        if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                            bfsQueueX.add(x);
                            bfsQueueY.add(y + 1);
                        }
                    }
                }
            }
        }


        return ans;
    }


    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        LeetCode200 leetCode200 = new LeetCode200();
        System.out.println(leetCode200.numIslands(grid));
    }
}
