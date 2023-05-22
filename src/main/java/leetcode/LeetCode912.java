package leetcode;

import java.util.Arrays;

/**
 * 排序
 */
public class LeetCode912 {
    private static int SELECT_SORT_LENGTH = 7;
    private static int[] sortedNum;

    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        sortedNum = new int[nums.length];
        mergeSort(nums, left, right);
        return nums;
    }


    /**
     * 归并排序
     */
    private int[] mergeSort(int[] nums, int left, int right) {
        if (right - left + 1 <= SELECT_SORT_LENGTH) {
            selectSort(nums, left, right);
            return nums;
        }
        int middle = (left + right) >> 1;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        mergeSortedNum(nums, left, right);

        return nums;
    }


    /**
     * 把两个排好序的数组合并到一起
     */
    private void mergeSortedNum(int[] nums, int left, int right) {
        System.arraycopy(nums, left, sortedNum, left, right - left + 1);

        int middle = (left + right) >> 1;
        int l2 = middle + 1;
        int now = left;

        while (l2 <= right || left <= middle) {
            if (l2 > right) {
                nums[now] = sortedNum[left++];
            } else if (left > middle) {
                nums[now] = sortedNum[l2++];
            } else if (sortedNum[left] <= sortedNum[l2]) {
                nums[now] = sortedNum[left++];
            } else if (sortedNum[left] > sortedNum[l2]) {
                nums[now] = sortedNum[l2++];
            }

            now++;
        }
    }

    /**
     * 选择排序
     */
    private void selectSort(int[] num, int left, int right) {
        for (int i = left; i <= right; i++) {
            int min = i;
            for (int j = i + 1; j <= right; j++) {
                if (num[min] > num[j]) {
                    min = j;
                }
            }
            swap(num, i, min);
        }
    }

    /**
     * 交换顺序
     * 使用异或进行交换
     * a1=a^b
     * b1=a1^b=a^b^b=a;
     * a=b1^a1=a^a^b=b;
     */
    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[i] ^ nums[j];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,1,2,0,0,0,0,0,0,0,0,0};
        LeetCode912 leetCode912 = new LeetCode912();
        leetCode912.sortArray(nums);
        System.out.println(nums);
    }

}
