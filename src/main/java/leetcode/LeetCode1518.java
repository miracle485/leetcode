package leetcode;

public class LeetCode1518 {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int now = numBottles;
        int sum = numBottles;
        while (now > 0) {
            int c=now/numExchange;
            if (c==0){
                break;
            }
            sum+=c;
            now=now-c*numExchange+c;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(LeetCode1518.numWaterBottles(9,3));
    }
}
