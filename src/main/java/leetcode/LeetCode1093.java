package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author = wangyilin29
 * @date = 2024/3/21
 **/
public class LeetCode1093 {
    public static void main(String[] args) {
        int[] count = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3510, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6718, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 27870, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26256, 0, 0, 0, 0, 9586565, 0, 0, 0, 0, 0, 0, 0, 2333, 0, 0, 0, 0};
        LeetCode1093 leetCode1093 = new LeetCode1093();
        leetCode1093.sampleStats(count);
    }

    public double[] sampleStats(int[] count) {
        Map<Integer, Integer> map = new HashMap<>();
        double[] result = new double[5];
        result[0] = -1;
        int n = 0;
        int c = 0;
        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            result[1] = i;
            if (result[0] == -1) {
                result[0] = i;
            }
            result[2] += 1.0d * i * count[i];
            n += count[i];
            if (count[i] > c) {
                c = count[i];
                result[4] = i;
            }
        }
        int mid1 = 0;
        int mid2 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            mid1 = (n) >> 1;
            mid2 = ((n) >> 1) + 1;
        } else {
            mid1 = (n + 1) >> 1;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            index += count[i];
            if (index >= mid1 && mid1 != -1) {
                mid1 = -1;
                result[3] += i;
            }
            if (index >= mid2 && mid2 != -1) {
                mid2 = -1;
                result[3] += i;
            }
        }
        if (mid2 == -1) {
            result[3] /= 2;
        }
        result[2] /= n;

        return result;
    }
}
