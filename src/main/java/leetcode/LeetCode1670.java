package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author = wangyilin29
 * @date = 2023/11/28
 **/
public class LeetCode1670 {
    private LinkedList<Integer> list;
    private int size;

    public LeetCode1670() {
        list = new LinkedList<>();
        size = 0;
    }

    public static void main(String[] args) {
        LeetCode1670 leetCode1670 = new LeetCode1670();
        leetCode1670.pushFront(1);
        leetCode1670.pushBack(2);
        leetCode1670.pushMiddle(3);
        leetCode1670.pushMiddle(4);
        leetCode1670.popFront();
        leetCode1670.popMiddle();
        leetCode1670.popMiddle();
        leetCode1670.popBack();
        leetCode1670.popFront();
    }

    public void pushFront(int val) {
        size++;
        list.addFirst(val);
    }

    public void pushMiddle(int val) {
        int mid = (size) >> 1;
        size++;
        list.add(mid, val);
    }

    public void pushBack(int val) {
        list.addLast(val);
        size++;
    }

    public int popFront() {
        if (size == 0) {
            return -1;
        }
        size--;
        return list.removeFirst();
    }

    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        int mid = (size - 1) >> 1;
        size--;
        return list.remove(mid);
    }

    public int popBack() {
        if (size == 0) {
            return -1;
        }
        size--;
        return list.removeLast();
    }
}
