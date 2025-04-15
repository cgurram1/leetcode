class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        return fun(0,0,obstacleGrid,dp);
    }

    public int fun(int i,int j, int [][] obstacleGrid,int [][] dp){
        if(i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1){
            return 0;
        }
        if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = fun(i+1,j,obstacleGrid,dp);
        int down = fun(i,j+1,obstacleGrid,dp);
        dp[i][j] = right + down;
        return dp[i][j];
    }
}