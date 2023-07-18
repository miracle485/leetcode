package leetcode;

public class LeetCode1375 {
    public int numTimesAllBlue(int[] flips) {
        int max = -1;
        int result = 0;
        for (int i = 0; i < flips.length; i++) {
            max = Math.max(flips[i], max);
            if (max == i + 1){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(0xf);
    }
}
