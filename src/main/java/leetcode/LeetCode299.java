package leetcode;

/**
 * @author = wangyilin29
 * @date = 2024/3/12
 **/
public class LeetCode299 {
    public static void main(String[] args) {
        LeetCode299 leetCode29 = new LeetCode299();
        System.out.println(leetCode29.getHint("1123", "0111"));
    }

    public String getHint(String secret, String guess) {
        char[] secretChar = secret.toCharArray();
        char[] guessChar = guess.toCharArray();
        int ac = 0;
        int bc = 0;
        int[] nm = new int[10];
        for (int i = 0; i < secretChar.length; i++) {
            if (secretChar[i] == guessChar[i]) {
                ac++;
            } else {
                nm[secretChar[i] - '0']++;
            }
        }

        for (int i = 0; i < secretChar.length; i++) {
            if (secretChar[i] == guessChar[i]) {
                continue;
            } else if (--nm[guessChar[i] - '0'] >= 0) {
                bc++;
            }
        }
        return ac + "A" + bc + "B";
    }
}
