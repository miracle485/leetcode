package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author = wangyilin29
 * @date = 2024/3/5
 **/
public class LeetCode1976 {
    private int[] preRoad;
    private Map<Integer, List<Road>> map;

    private int result = 0;

    public int countPaths(int n, int[][] roads) {
        preRoad = new int[n + 1];
        for (int[] road : roads) {
            Road r = new Road();
            r.start = road[0];
            r.end = road[1];
            r.value = road[2];
            List<Road> list = map.getOrDefault(r.start, new ArrayList<>());
            list.add(r);
            map.put(r.start, list);
        }
        dfs(0, n - 1, 0);
        return result;
    }

    public int dfs(int now, int end, int value) {
        if (now == end - 1) {
            return value;
        }
        List<Road> roads = map.getOrDefault(now, new ArrayList<>());
        for (Road road : roads) {

        }
        return 0;
    }

    static class Road {
        int start;
        int end;
        int value;
    }
}
