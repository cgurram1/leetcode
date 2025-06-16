class Solution {
    public int [] X = new int[]{1,-1,0,0};
    public int [] Y = new int[]{0,0,1,-1};
    public int [][] visited;
    public int getMaximumGold(int[][] grid) {
        this.visited = new int[grid.length][grid[0].length];
        int result = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] > 0){
                    result = Math.max(result,fun(i,j,grid));
                }
            }
        }
        return result;
    }
    public int fun(int x, int y,int [][] grid){
        visited[x][y] = 1;
        int val = 0;
        for(int i = 0;i<4;i++){
            int nextX = x + X[i];
            int nextY = y + Y[i];
            if(nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && this.visited[nextX][nextY] != 1 && grid[nextX][nextY] > 0){
                val = Math.max(val,fun(nextX,nextY,grid));
            }
        }
        visited[x][y] = 0;
        return grid[x][y] + val;
    }
}