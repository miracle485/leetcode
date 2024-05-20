package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LeetCode826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Work> works = new ArrayList<>();
        for (int i = 0; i < profit.length; i++) {
            works.add(new Work(profit[i], difficulty[i]));
        }
        int result = 0;
        works.sort(Comparator.comparingInt(o -> o.difficulty));
        int cp = works.get(0).profit;
        for (Work work : works) {
            if (work.profit > cp) {
                cp = work.profit;
            } else {
                work.profit = cp;
            }
        }
        for (int wor : worker) {

        }

        return result;
    }

    private int findProfit(List<Work> works, int worker) {
        int left = 0, right = works.size();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (works.get(mid).difficulty > worker) {

            }
        }
        return 1;
    }

    private static class Work {
        int profit;
        int difficulty;

        public Work(int profit, int difficulty) {
            this.profit = profit;
            this.difficulty = difficulty;
        }
    }
}
