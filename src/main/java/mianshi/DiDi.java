package mianshi;

public class DiDi {
    private int m, n;
    private int[] s = new int[]{1, 2, 5};

    public int check(int m, int n) {
        this.m = m;
        this.n = n;
        return dfs(0, n);
    }

    private int dfs(int sum, int n) {
        if (n == 0) {
            return sum == m ? 1 : 0;
        }
        int r = 0;
        for (int j : s) {
            r += dfs(sum + j, n - 1);
        }
        return r;
    }
}
