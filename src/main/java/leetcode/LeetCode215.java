package leetcode;



public class LeetCode215 {
    private int size;
    private int cap;
    private int[] heap;

    public int findKthLargest(int[] nums, int k) {
        cap = nums.length;
        size = 0;
        heap = new int[cap + 1];
        for (int num : nums) {
            add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            removeHead();
        }
        return heap[1];
    }

    public int leftChild(int index) {
        if ((2 * index) <= size) {
            return (2 * index);
        }
        return -1;
    }

    public int rightChild(int index) {
        if ((2 * index + 1) <= size) {
            return 2 * index + 1;
        }
        return -1;
    }

    public int parent(int index) {
        if (index == 0) {
            return -1;
        }
        return index / 2;
    }

    private void add(int value) {
        if (size > cap - 1) {
            return;
        }
        size++;
        heap[size] = value;
        headUp(size);
    }

    public void headUp(int index) {
        while (index > 0 && parent(index) > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public void swap(int index1, int index2) {
        int curr = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = curr;
    }

    public void removeHead() {
        if (size == 0) {
            return;
        }
        heap[1] = heap[size];
        heap[size] = Integer.MIN_VALUE;
        size--;
        headDown(1);
    }

    public void headDown(int index) {
        if (size == 0) {
            return;
        }
        while (true) {
            int maxPos = index;
            int left = leftChild(index);
            int right = rightChild(index);
            if (left > 0 && left <= size && heap[maxPos] < heap[left]) {
                maxPos = left;
            }
            if (right > 0 && right <= size && heap[maxPos] < heap[right]) {
                maxPos = right;
            }
            if (maxPos == index) {
                break;
            }
            swap(index, maxPos);
            index = maxPos;
        }
    }

    public static void main(String[] args) {
        LeetCode215 leetCode215 = new LeetCode215();
        System.out.println(leetCode215.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
