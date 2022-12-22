package leetcode;

public class LeetCode901 {
    private int preInt = 0;
    private int preDay = 1;

    public int next(int price) {
        if (price < preInt) {
            preDay++;
        } else {
            preDay = 1;
        }
        preInt = price;
        return preDay;
    }
}
