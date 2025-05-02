class Solution {
    int [] xNext = new int[]{1,-1,0,0};
    int [] yNext = new int[]{0,0,1,-1};
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    result = Math.max(result,dfs(i,j,grid) + 1);
                    System.out.println(result);
                }
            }   
        }
        return result;
    }
    public int dfs(int x,int y,int [][]grid) {
        grid[x][y] = 0;
        int count = 0;
        for(int k = 0;k<4;k++){
            int nextx = x + xNext[k];
            int nexty = y + yNext[k];
            if(nextx >= 0 && nexty >= 0 && nextx < grid.length && nexty < grid[0].length && grid[nextx][nexty] == 1){
                
                count = count + 1 + dfs(nextx,nexty,grid);
            }
        }
        return count;
    }
}