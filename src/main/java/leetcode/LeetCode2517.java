package leetcode;

import java.util.Arrays;

public class LeetCode2517 {
    public int maximumTastiness(int[] price, int k) {
        int left = 0;
        Arrays.sort(price);
        int right = price[price.length - 1];

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (check(price, mid, k)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    public boolean check(int[] price, int tastiness, int k) {
        int cnt = 0;
        int pre = -10000000;
        for (int j : price) {
            if (j - pre > tastiness) {
                cnt++;
                pre = j;
            }
        }

        return cnt >= k;
    }

    public static void main(String[] args) {
        int[] price = new int[]{13, 5, 1, 8, 21, 2};
        LeetCode2517 leetCode2517 = new LeetCode2517();
        System.out.println(leetCode2517.maximumTastiness(price, 3));
    }
}
