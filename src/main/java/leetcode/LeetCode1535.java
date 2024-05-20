package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1535 {
    public static void main(String[] args) {
        int[] cc = new int[]{2, 1, 3, 5, 4, 6, 7};
        int k = 2;
        LeetCode1535 leetCode1535 = new LeetCode1535();
        System.out.println(leetCode1535.getWinner(cc, k));
    }

    public int getWinner(int[] arr, int k) {
        int max = 0;
        int maxIndex = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        if (k >= maxIndex) {
            return max;
        }
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(0);
        for (int i = 1; i <= maxIndex; i++) {
            while (!deque.isEmpty() && (arr[deque.peek()] < arr[i])) {
                Integer poll = deque.poll();
                if (deque.isEmpty()) {
                    int cm = -1;
                    if (poll == 0 && (i - poll - 1 >= k)) {
                        cm = poll;
                    }
                    if (poll != 0 && i - poll >= k) {
                        cm = poll;
                    }
                    if (cm != -1 && result > cm) {
                        result = cm;
                    }

                }
            }
            deque.offerFirst(i);
        }

        return arr[result];
    }

}
