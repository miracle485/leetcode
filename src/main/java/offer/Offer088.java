package offer;

public class Offer088 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[2] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return Math.min(dp[cost.length - 1] + cost[cost.length - 1], dp[cost.length - 2] + cost[cost.length - 2]);
    }

    public static void main(String[] args) {
        Offer088 offer088 = new Offer088();
        System.out.println(offer088.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}
