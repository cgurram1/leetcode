class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fun(0, 0, m, n, dp);
    }

    public int fun(int i, int j, int m, int n, int[][] dp) {
        if (i >= m || j >= n) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int down = fun(i + 1, j, m, n, dp);
        int right = fun(i, j + 1, m, n, dp);

        dp[i][j] = down + right;
        return dp[i][j];
    }
}
