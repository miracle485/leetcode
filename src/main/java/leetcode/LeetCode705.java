package leetcode;

import java.util.Arrays;

public class LeetCode705 {
    private int[] set;

    public void MyHashSet() {
        set = new int[1000001];
    }

    public void add(int key) {
        set[key] = 1;
    }

    public void remove(int key) {
        set[key] = 0;
    }

    public boolean contains(int key) {
        return set[key] == 1;
    }
}
