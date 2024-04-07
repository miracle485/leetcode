package bisai;

import java.util.Arrays;

/**
 * @author = wangyilin29
 * @date = 2024/4/7
 **/
public class JingSai100277 {
    public static void main(String[] args) {
        JingSai100277 jingSai100277 = new JingSai100277();
        System.out.println(jingSai100277.minOperationsToMakeMedianK(new int[]{1000000000, 1000000000, 1000000000}, 1));
    }

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        long result = 0;
        int mid = nums.length / 2;
        if (nums[mid] == k) {
            return 0;
        }
        if (nums[mid] < k) {
            result += findUpperMid(nums, mid, k);
        } else {
            result += findLowerMid(nums, mid, k);
        }

        return result;
    }

    private long findUpperMid(int[] nums, int mid, int k) {
        long result = 0;
        for (int i = mid; i < nums.length; i++) {
            if (nums[i] >= k) {
                break;
            }
            result += (k - nums[i]);
        }
        return result;
    }

    private long findLowerMid(int[] nums, int mid, int k) {
        long result = 0;
        for (int i = mid; i >= 0; i--) {
            if (nums[i] <= k) {
                break;
            }
            result += (nums[i] - k);
        }
        return result;
    }
}
