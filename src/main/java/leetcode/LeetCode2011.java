package leetcode;

public class LeetCode2011 {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        if (operations == null || operations.length == 0) {
            return ans;
        }
        for (String op : operations) {
            if ("++X".equals(op) || "X++".equals(op)) {
                ans++;
            } else if ("--X".equals(op) || "X--".equals(op)) {
                ans--;
            }
        }
        return ans;
    }
}
