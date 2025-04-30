class Solution {
    int [] x = new int[]{1,-1,0,0};
    int [] y = new int[]{0,0,-1,1};
    public int numIslands(char[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int noOfIslands = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0; j< grid[i].length;j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    noOfIslands+=1;
                    traverse(i,j,grid,visited);
                }
            }
        }
        return noOfIslands;
    }
    public void traverse(int i, int j, char [][] grid, boolean [][] visited){
        visited[i][j] = true;
        for(int k = 0;k<4;k++){
            int iNext = i + x[k];
            int jNext = j + y[k];
            if(iNext >= 0 && iNext < grid.length && jNext >= 0 && jNext < grid[0].length && grid[iNext][jNext] == '1' && visited[iNext][jNext] == false){
                traverse(iNext, jNext, grid,visited);
            }
        }
    }
}