package leetcode;

import java.util.*;

/**
 * @author = wangyilin29
 * @date = 2024/3/26
 **/
public class LeetCode2642 {
    private final int inf = Integer.MAX_VALUE / 2;
    private int n;
    private int[][] graph;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LeetCode2642 leetCode2642 = new LeetCode2642();
        leetCode2642.Graph(13, new int[][]{{11, 6, 84715}, {7, 9, 764823}, {6, 0, 315591}, {1, 4, 909432}, {6, 5, 514907}, {9, 6, 105610}, {3, 10, 471042}, {7, 10, 348752}, {5, 11, 715628}, {6, 1, 973999}, {8, 7, 593929}, {7, 6, 64688}, {6, 4, 741734}, {10, 1, 894247}, {9, 7, 81181}, {2, 11, 75418}, {12, 2, 85431}, {7, 2, 260306}, {11, 9, 640614}, {2, 3, 648804}, {4, 12, 568023}, {0, 8, 730096}, {9, 11, 633474}, {3, 6, 390214}, {1, 10, 117955}, {9, 8, 222602}, {10, 7, 689294}});
        leetCode2642.addEdge(new int[]{1, 2, 36450});
        leetCode2642.addEdge(new int[]{8, 0, 709628});
        leetCode2642.addEdge(new int[]{2, 4, 30185});
        leetCode2642.addEdge(new int[]{12, 1, 21696});
        leetCode2642.addEdge(new int[]{1, 8, 2553});

        leetCode2642.addEdge(new int[]{4, 6, 2182});
        leetCode2642.addEdge(new int[]{7, 5, 206});
        leetCode2642.addEdge(new int[]{5, 7, 140});
        System.out.println(leetCode2642.shortestPath(12, 5));
        System.out.println(System.currentTimeMillis() - start);
        //leetCode2642.shortestPath(0, 3);
    }

    public void Graph(int n, int[][] edges) {
        this.n = n;
        graph = new int[n][n];
        for (int[] ints : graph) {
            Arrays.fill(ints, inf);
        }
        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        graph[edge[0]][edge[1]] = edge[2];
    }


    public int shortestPath(int node1, int node2) {
        int[] dis = new int[n];
        Arrays.fill(dis, inf);
        int[] done = new int[n];
        dis[node1] = 0;
        while (true) {
            int x = -1;
            for (int i = 0; i < dis.length; i++) {
                if (done[i] == 0 && (x < 0 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            if (x < 0) {
                break;
            }
            done[x] = 1;
            if (dis[x] == inf) {
                continue;
            }

            if (x == node2) {
                return dis[node2];
            }
            for (int i = 0; i < n; i++) {
                dis[i] = Math.min(dis[i], dis[x] + graph[x][i]);
            }
        }

        return -1;
    }

    private static class Edge {
        int to;
        int value;

        public Edge(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
}
