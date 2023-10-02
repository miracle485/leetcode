package leetcode;

public class LeetCode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0) {
                return n == 1;
            } else {
                return n == 0;
            }
        }
        int result = 0;
        if (flowerbed[1] == 0 && flowerbed[0] == 0) {
            flowerbed[0] = 1;
            result++;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            boolean pre = (i - 1 >= 0) && flowerbed[i - 1] == 0;
            boolean sub = i + 1 < flowerbed.length && flowerbed[i + 1] == 0;
            if (pre && sub && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                result++;
            }
        }
        if (flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
            result++;
        }

        return result >= n;
    }

    public static void main(String[] args) {
        int[] flo = new int[]{1, 0, 0, 0, 1, 0, 0};
        int n = 1;
        LeetCode605 leetCode605 = new LeetCode605();
        leetCode605.canPlaceFlowers(flo, n);
    }
}
