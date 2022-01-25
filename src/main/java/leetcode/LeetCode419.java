package leetcode;

public class LeetCode419 {
    public static int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    boolean x = (i == 0 || board[i - 1][j] != 'X');
                    boolean y = (j == 0 || board[i][j - 1] != 'X');
                    if (x&y){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode419.countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}}));
    }
}
