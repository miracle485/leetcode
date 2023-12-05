package leetcode;

/**
 * @author = wangyilin29
 * @date = 2023/12/4
 **/
public class LeetCode36 {
    public static void main(String[] args) {
        char[][] as = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        LeetCode36 leetCode36 = new LeetCode36();
        leetCode36.isValidSudoku(as);
    }

    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] bows = new int[9][10];
        int[][] ks = new int[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int x = board[i][j] - '0';
                if (x < 0 || x > 9) {
                    continue;
                }
                if (rows[i][x] != 0) {
                    return false;
                }
                rows[i][x] = 1;
                if (bows[j][x] != 0) {
                    return false;
                }
                bows[j][x] = 1;
                int index = i / 3 * 3 + j / 3;
                if (ks[index][x] != 0) {
                    return false;
                }
                ks[index][x] = 1;
            }
        }

        return true;
    }
}
