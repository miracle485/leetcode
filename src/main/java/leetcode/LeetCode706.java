package leetcode;

import java.util.Arrays;

/**
 * @author = wangyilin29
 * @date = 2024/4/15
 **/
public class LeetCode706 {
    private int[] map;

    public void MyHashMap() {
        map = new int[100001];
        Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}
