class Solution {
    private static final int MOD = 1_000_000_007;
    private final int[] dx = {1,-1,0,0};
    private final int[] dy = {0,0,1,-1};
    private int m, n;
    private Integer[][][] memo;

    public int findPaths(int m, int n, int maxMove, int row, int col) {
        this.m = m;
        this.n = n;
        memo = new Integer[m][n][maxMove + 1];
        return dfs(row, col, maxMove);
    }

    private int dfs(int x, int y, int rem) {
        if (x < 0 || x >= m || y < 0 || y >= n) return 1;
        if (rem == 0) return 0;
        if (memo[x][y][rem] != null) return memo[x][y][rem];

        long res = 0;
        for (int k = 0; k < 4; k++) {
            res += dfs(x + dx[k], y + dy[k], rem - 1);
        }
        return memo[x][y][rem] = (int) (res % MOD);
    }
}