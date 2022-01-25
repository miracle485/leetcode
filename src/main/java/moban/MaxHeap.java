package moban;

public class MaxHeap {
    int size;
    int cap;
    int[] heap;

    public MaxHeap(int cap) {
        this.cap = cap;
        size = 0;
        heap = new int[cap + 1];
    }

    public int leftChild(int index) {
        if ((2 * index) < size) {
            return 2 * index;
        }
        return -1;
    }

    public int rightChild(int index) {
        if ((2 * index + 1) < size) {
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

    public void add(int value) {
        if (size >= cap - 1) {
            return;
        }
        size++;
        heap[size] = value;
        headUp(size);
    }

    public void headUp(int index) {
        while (index > 0 && (parent(index) > 0) && heap[index] < heap[parent(index)]) {
            int curr = heap[index];
            heap[index] = heap[parent(index)];
            heap[parent(index)] = curr;

            index = parent(index);
        }
    }

    public int remove() {
        if (size == 0) {
            return -1;
        }
        int pop = heap[1];
        heap[size] = Integer.MIN_VALUE;
        size--;
        headDown(size);
        return pop;
    }

    public void headDown(int index) {

    }
}
