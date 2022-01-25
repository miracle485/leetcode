package leetcode;

public class LeetCode475 {
    public int findRadius(int[] houses, int[] heaters) {
        int result = Integer.MAX_VALUE;
        int left = 0, right = (int) 1e9;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (testResult(houses, heaters, mid)) {
                right = mid - 1;
                result = mid;

            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public boolean testResult(int[] houses, int[] heaters, int mid) {

        return true;
    }

}
