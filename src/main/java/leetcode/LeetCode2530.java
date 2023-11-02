package leetcode;

import java.util.PriorityQueue;

public class LeetCode2530 {

    public long maxKelements(int[] nums, int k) {
        long result = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = priorityQueue.poll();
            Integer c = (int) Math.ceil(1.0 * poll / 3);
            result+=poll;
            priorityQueue.offer(c);
        }
        return result;
    }


}
