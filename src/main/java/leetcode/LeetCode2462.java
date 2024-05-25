package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.CyclicBarrier;

public class LeetCode2462 {
    private int[] pre;
    private int[] last;
    private final Comparator<Worker> comparator = (w1, w2) -> {
        if (w1.cost == w2.cost) {
            return w1.index - w2.index;
        }
        return w1.cost - w2.cost;
    };

    public static void main(String[] args) {
        LeetCode2462 leetCode2462 = new LeetCode2462();
        int[] costs = new int[]{980, 719, 216, 384, 883, 283, 880, 230, 882, 142, 806, 218, 604, 299, 285, 949, 237, 319, 680, 278, 143, 697, 406, 464, 962, 415, 325, 99, 636, 577, 701, 205, 38, 154, 130, 232, 897, 188, 831, 467, 278, 492, 159, 368, 998, 572, 870, 794, 949, 939, 904, 15, 505, 996, 767, 562, 414, 65, 473, 841, 400, 18, 260, 410, 615, 902, 266, 732, 543, 746, 686, 804, 714, 318, 756, 803, 826, 843, 297, 369, 950, 495, 379, 2, 919, 283, 397, 463, 271, 132, 40, 452, 366, 269, 276, 283, 563, 281, 697, 878};
        System.out.println(leetCode2462.totalCost(costs, 59, 15));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int peopleNum = costs.length;
        PriorityQueue<Worker> pre = new PriorityQueue<>(comparator);
        PriorityQueue<Worker> last = new PriorityQueue<>(comparator);
        int left = candidates - 1;
        int right = peopleNum;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        for (int i = 0; i < candidates; i++) {
            pre.add(new Worker(i, costs[i]));
            costs[i] = Integer.MAX_VALUE;
            last.add(new Worker(--right, costs[right]));
            costs[right] = Integer.MAX_VALUE;
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int preCost = Integer.MAX_VALUE, lastCost = Integer.MAX_VALUE;
            if (!pre.isEmpty()) {
                preCost = pre.peek().cost;
            }
            if (!last.isEmpty()) {
                lastCost = last.peek().cost;
            }
            if (preCost > lastCost) {
                sum += lastCost;
                last.poll();
                if (--right >= 0) {
                    last.add(new Worker(right, costs[right]));
                    costs[right] = Integer.MAX_VALUE;
                }
            } else {
                sum += preCost;
                pre.poll();
                if (++left < costs.length) {
                    pre.add(new Worker(left, costs[left]));
                    costs[left] = Integer.MAX_VALUE;
                }
            }
            peopleNum--;
        }
        return sum;
    }

    private static class Worker {
        int index;
        int cost;

        public Worker(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

}
