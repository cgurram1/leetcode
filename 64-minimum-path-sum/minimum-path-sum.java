class Solution {
    public int minPathSum(int[][] grid) {
        int [][] dp = new int[grid.length+1][grid[0].length];
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        return fun(0,0,grid,dp);
    }
    public int fun(int i,int j,int [][] grid, int [][] dp){
        if(i == grid.length || j == grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = fun(i+1,j,grid,dp);
        int right = fun(i,j+1,grid,dp);
        dp[i][j] = Math.min(down,right) + grid[i][j];
        return dp[i][j];
    }
}