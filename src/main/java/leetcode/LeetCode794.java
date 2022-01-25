package leetcode;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class LeetCode794 {
    public static boolean validTicTacToe(String[] board) {
        int xnum = 0, onum = 0;
        char[][] chars = new char[3][3];
        for (int i = 0; i < 3; i++) {
            char[] curr = board[i].toCharArray();
            for (int j = 0; j < 3; j++) {
                chars[i][j] = curr[j];
                if (curr[j] == 'X') {
                    xnum++;
                } else if (curr[j] == 'O') {
                    onum++;
                }
            }
        }
        if (xnum < onum || (Math.abs(xnum - onum) > 1)) {
            return false;
        }
        int xthree = 0, othree = 0;
        for (int i = 0; i < 3; i++) {
            if (chars[i][0] == chars[i][1] && chars[i][1] == chars[i][2] && chars[i][0] != ' ') {
                if (chars[i][0] == 'X') {
                    xthree++;
                } else {
                    othree++;
                }
                chars[i][0] = ' ';
                chars[i][2] = ' ';
            }
        }
        for (int i = 0; i < 3; i++) {
            if (chars[0][i] == chars[1][i] && chars[1][i] == chars[2][i] && chars[0][i] != ' ') {
                if (chars[0][i] == 'X') {
                    xthree++;
                } else {
                    othree++;
                }
                chars[0][i] = ' ';
                chars[2][i] = ' ';
            }
        }
        if (chars[0][0] == chars[1][1] && chars[1][1] == chars[2][2] && chars[0][0] != ' ') {
            if (chars[1][1] == 'X') {
                xthree++;
            } else {
                othree++;
            }
            chars[1][1] = ' ';
        }
        if (chars[0][2] == chars[1][1] && chars[1][1] == chars[2][0] && chars[1][1] != ' ') {
            if (chars[1][1] == 'X') {
                xthree++;
            } else {
                othree++;
            }
        }
        boolean flag = (xthree == 0 || othree == 0) && xthree <= 1 && othree <= 1;
        if (!flag) {
            return flag;
        }
        if (xthree != 0) {
            flag = (xnum > onum);
        }
        if (othree != 0) {
            flag = (xnum == onum);
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode794.validTicTacToe(new String[]{"XXO", "XOX", "OXO "}));
    }
}
