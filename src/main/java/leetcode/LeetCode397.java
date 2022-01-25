package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode397 {
    public int integerReplacement(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int flag = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isOne = false;
            while (size > 0) {
                int curr = queue.poll();
                int c1 = 0, c2 = 0, c3 = 0;
//                if (curr == 1) {
//                    isOne = true;
//                    break;
//                }
                if (curr % 2 == 0) {
                    c1 = curr / 2;
                    queue.add(c1);
                } else {
                    c2 = curr + 1;
                    c3 = curr - 1;
                    if (c2 > 0) {
                        queue.add(c2);
                    }
                    if (c3 > 0) {
                        queue.add(c3);
                    }

                }
                if (c1 == 1 || c2 == 1 || c3 == 1) {
                    isOne = true;
                    break;
                }
                size--;
            }
            if (isOne) {
                break;
            }
            flag++;

        }
        return flag;
    }

    public static void main(String[] args) {
        LeetCode397 leetCode397 = new LeetCode397();
        System.out.println(leetCode397.integerReplacement(Integer.MAX_VALUE-1));
    }
}
