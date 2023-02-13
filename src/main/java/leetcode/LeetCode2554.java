package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode2554 {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> banSet = new HashSet<>();
        for (int banI : banned) {
            banSet.add(banI);
        }
        int ans = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (banSet.contains(i)){
                continue;
            }
            if (sum+i<=maxSum){
                sum+=i;
                ans++;
                continue;
            }
            break;
        }
        return ans;
    }
}
