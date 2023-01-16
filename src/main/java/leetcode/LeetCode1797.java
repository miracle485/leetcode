package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1797 {
    int timeToLive;
    Map<String, Integer> tokenMap = new HashMap<>();

    public LeetCode1797(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer oldTime = tokenMap.getOrDefault(tokenId, 0);
        if (oldTime <= currentTime) {
            return;
        }
        tokenMap.put(tokenId, currentTime + timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        int result = 0;
        for (Map.Entry<String, Integer> entry : tokenMap.entrySet()) {
            if (entry.getValue() > currentTime) {
                result++;
            }
        }

        return result;
    }
}
