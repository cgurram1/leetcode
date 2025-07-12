class Solution {
    public int minPathSum(int[][] grid) {
        int [][] dp = new int[grid.length][grid[0].length];
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        return fun(0,0,grid,dp);
    }
    public int fun(int x, int y, int [][] grid, int [][] dp){
        if(x >= grid.length || y >= grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(x == grid.length-1 && y == grid[0].length-1){
            return grid[x][y];
        }
        if(dp[x][y]!= -1){
            return dp[x][y];
        } 
        int down = fun(x,y+1,grid,dp);
        int right = fun(x+1,y,grid,dp);
        dp[x][y] = Math.min(down, right) + grid[x][y];
        return dp[x][y];
    }
}