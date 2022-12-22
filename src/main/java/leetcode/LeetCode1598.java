package leetcode;

public class LeetCode1598 {
    public int minOperations(String[] logs) {
        int ans = 0;
        if (logs == null || logs.length == 0) {
            return ans;
        }
        for (String log : logs) {
            if ("../".equals(log)) {
                if (ans > 0) {
                    ans--;
                }
            } else if ("./".equals(log)) {

            } else {
                ans++;
            }
        }
        return ans;
    }
}
