package leetcode;

public class LeetCode1446 {
    public static int maxPower(String s) {
        int ans = 1;
        int result=1;
        char now, pre = 0;
        for (char c : s.toCharArray()) {
            if (c == pre) {
                ans++;
                result=Math.max(ans,result);
                continue;
            }
            result=Math.max(ans,result);
            pre = c;
            ans=1;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
