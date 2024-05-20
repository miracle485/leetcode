package LCR;

public class LCR076 {
    public static void main(String[] args) {
        LCR076 lcr076 = new LCR076();
        lcr076.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(nums, left, right);
        quickSort(nums, left, partition);
        quickSort(nums, partition + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] > nums[left]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, left, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int x, int y) {
        if (x == y) {
            return;
        }
        nums[x] = nums[x] ^ nums[y];
        nums[y] = nums[y] ^ nums[x];
        nums[x] = nums[x] ^ nums[y];
    }
}
