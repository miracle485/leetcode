package leetcode;

public class LeetCode901 {
    private int preInt = 0;
    private int preDay = 1;
    private int[] prices = new int[10000];
    private int[] kc = new int[10000];
    private int flag = 0;

    public int next(int price) {
        return 0;
    }

    public int next2(int price) {
        int sum = 0;
        kc[flag] = 1;
        prices[flag] = price;
        int now = flag;
        while (now >= 0 &&prices[now] <= price) {
            sum++;
            now -= kc[now];
        }
        flag++;
        return sum;
    }

    public static void main(String[] args) {
        LeetCode901 leetCode901 = new LeetCode901();
        System.out.println(leetCode901.next2(100));
        System.out.println(leetCode901.next2(80));
    }
}
