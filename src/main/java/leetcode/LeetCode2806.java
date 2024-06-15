package leetcode;

public class LeetCode2806 {
    public static void main(String[] args) {
        System.out.println(LeetCode2806.accountBalanceAfterPurchase(9));
    }

    public static int accountBalanceAfterPurchase(int purchaseAmount) {
        int consume = (purchaseAmount % 10 >= 5) ? (purchaseAmount + 10 - purchaseAmount % 10) : (purchaseAmount - purchaseAmount % 10);

        return 100 - consume;
    }
}
