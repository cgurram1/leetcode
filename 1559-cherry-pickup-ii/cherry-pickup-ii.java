class Solution {
    public int cherryPickup(int[][] grid) {
        int [][][] dp = new int[grid.length+1][grid[0].length + 1][grid[0].length+1];
        for(int [][] arrOuter : dp){
            for(int [] arr : arrOuter){
                Arrays.fill(arr,-1);
            }
        }
        return fun(0,0,grid[0].length-1,grid, dp);
    }
    public int fun(int row, int col1, int col2, int [][] grid, int [][][]dp){
        if(col1 < 0 || col2 < 0 || col1 >= grid[0].length || col2 >= grid[0].length){
            return 0;
        }
        if(row == grid.length-1){
            if(col1 == col2){
                return grid[row][col1];
            }
            else{
                return grid[row][col1] + grid[row][col2];
            }
        }
        if(dp[row][col1][col2] != -1){
            return dp[row][col1][col2];
        }
        int max = Integer.MIN_VALUE;
        for(int i = -1;i<2;i++){
            for(int j = -1;j<2;j++){
                if(col1 == col2){
                    max = Math.max(max,  grid[row][col1] + fun(row + 1, col1 + i, col2 + j, grid,dp));
                }
                else{
                    max = Math.max(max,  grid[row][col1] + grid[row][col2]  + fun(row + 1, col1 + i, col2 + j, grid,dp));
                }
            }
        }
        dp[row][col1][col2] = max;
        return dp[row][col1][col2];
    }
}