class Solution {
    int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    Double[][][] memo;
    public double knightProbability(int n, int k, int row, int column) {
        memo = new Double[n][n][k + 1];
        return dfs(n, k, row, column);
    }
    public double dfs(int n, int k, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) return 0.0;
        if (k == 0) return 1.0;
        if (memo[x][y][k] != null) return memo[x][y][k];
        double prob = 0.0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            prob += dfs(n, k - 1, nx, ny) / 8.0;
        }
        memo[x][y][k] = prob;
        return prob;
    }
}
