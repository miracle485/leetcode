package leetcode;

public class LeetCode33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int n = nums.length;
        int start = -1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int now = mid + n;
            if (nums[now % n] < nums[(now + 1) % n] && nums[now % n] < nums[(now - 1) % n]) {
                start = now % n;
                break;
            } else if (nums[now % n] > nums[(now - 1) % n] && nums[now % n] > nums[(now + 1) % n]) {
                start = (now + 1) % n;
                break;
            } else if (nums[now % n] > nums[(now - 1) % n]) {
                left = mid + 1;
            } else if (nums[now % n] > nums[(now + 1) % n]) {
                right = mid;
            }
        }
        if (start < 0) {
            start = left;
        }
        return nums[start % n];
    }

    public static void main(String[] args) {
        int[] cs = new int[]{4, 5, 6, 7, 0, 1, 2};
        LeetCode33 leetCode33 = new LeetCode33();
        leetCode33.search(cs, 0);
    }
}
