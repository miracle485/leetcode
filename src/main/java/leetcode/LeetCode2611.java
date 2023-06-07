package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2611 {
    private int[] r1;
    private int[] r2;

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        this.r1 = reward1;
        this.r2 = reward2;

        return dfs(0, 0, k, reward2.length - k);
    }

    private int dfs(int now, int sum, int k, int k2) {
        if (now >= r1.length) {
            return sum;
        }
        int s1 = 0;
        if (k > 0) {
            s1 = dfs(now + 1, sum + r1[now], k - 1, k2);
        }
        int s2 = 0;
        if (k2 > 0) {
            s2 = dfs(now + 1, sum + r2[now], k, k2 - 1);
        }
        return Math.max(s1, s2);
    }

    public static void main(String[] args) {
        int[] r1 = new int[]{54, 59, 94, 87, 32, 10, 55, 44, 21, 73, 12, 70, 89, 49, 13, 34, 78, 20, 20, 75, 90, 44, 48, 74, 78, 32, 70, 76, 79, 49, 50, 69};
        int[] r2 = new int[]{78, 43, 69, 22, 32, 67, 65, 38, 51, 4, 21, 27, 82, 61, 12, 85, 62, 60, 67, 16, 22, 3, 5, 16, 13, 35, 13, 41, 72, 85, 20, 54};
        LeetCode2611 leetCode2611 = new LeetCode2611();
        System.out.println(leetCode2611.miceAndCheese2(r1, r2, 17));
    }


    public int miceAndCheese2(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int result = 0;
        int ck = n - k;
        List<Reward> rewardList = new ArrayList<>();
        for (int i = 0; i < reward1.length; i++) {
            rewardList.add(new Reward(reward1[i], reward2[i]));
        }
        rewardList.sort((o1, o2) -> o2.value - o1.value);
        for (Reward reward : rewardList) {
            if (k <= 0 && ck <= 0) {
                break;
            }
            if (k > 0) {
                result += reward.r1;
                k--;
                continue;
            }

            result += reward.r2;
            ck--;
        }

        return result;
    }

    private static class Reward {
        int r1;
        int r2;
        int value;

        public Reward(int r1, int r2) {
            this.r1 = r1;
            this.r2 = r2;
            this.value = r1 - r2;
        }
    }
}
