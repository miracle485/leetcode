package leetcode;

public class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3];
        boolean result = true;
        for (int bill : bills) {
            if (bill == 5) {
                money[0]++;
            } else if (bill == 10) {
                if (money[0] == 0) {
                    result = false;
                    break;
                }
                money[1]++;
                money[0]--;
            } else if (bill == 20) {
                if (money[1] > 0 && money[0] > 0) {
                    money[2]++;
                    money[1]--;
                    money[0]--;
                } else if (money[0] > 3) {
                    money[2]++;
                    money[0] -= 3;
                } else {
                    result = false;
                    break;
                }
            }
        }


        return result;
    }
}
