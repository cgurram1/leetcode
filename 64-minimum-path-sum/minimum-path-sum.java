import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return rec(0, 0, grid, dp);
    }

    private int rec(int i, int j, int[][] grid, int[][] dp) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (i == rows - 1 && j == cols - 1) {
            return grid[i][j];
        }
        if (i >= rows || j >= cols) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = rec(i, j + 1, grid, dp);
        int down = rec(i + 1, j, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
}