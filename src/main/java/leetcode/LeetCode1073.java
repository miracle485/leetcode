package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i1 = arr1.length - 1, i2 = arr2.length - 1;
        int pre = 0;
        List<Integer> currList = new ArrayList<>();
        while (i1 >= 0 || i2 >= 0) {
            int now = 0;
            if (i2 >= 0) {
                now += arr2[i2];
            }
            if (i1 >= 0) {
                now += arr1[i1];
            }
            now += pre;
            if (now == -1) {
                now = 1;
                pre = 1;
            } else {
                pre = -now / 2;
                now = now % 2;
            }
            currList.add(now);

            i1--;
            i2--;
        }
        if (pre > 0) {
            currList.add(1);
        } else if (pre < 0) {
            currList.add(1);
            currList.add(1);
        }


        int size = currList.size();
        int[] result = null;
        int k = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (currList.get(i) != 0 && result == null) {
                result = new int[i + 1];
            }
            if (result != null) {
                result[k++] = currList.get(i);
            }
        }
        if (result == null) {
            result = new int[]{0};
        }

        return result;
    }

    public static void main(String[] args) {
        LeetCode1073 leetCode1073 = new LeetCode1073();
        leetCode1073.addNegabinary(new int[]{1, 0, 1}, new int[]{1, 0, 1});
    }
}
