class Solution {
    int [] xs = new int[]{1,-1,0,0};
    int [] ys = new int[]{0,0,1,-1};
    public int numIslands(char[][] grid) {
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    dfs(i,j,visited,grid);
                    count+=1;
                }
            }
        }
        return count;
    }
    public void dfs(int x, int y, boolean [][] visited, char[][] grid){
        visited[x][y] = true;
        for(int i = 0;i<4;i++){
            int nextX = x + xs[i];
            int nextY = y + ys[i];
            if(nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length && visited[nextX][nextY] == false && grid[nextX][nextY] == '1'){
                dfs(nextX,nextY,visited,grid);
            }
        }
    }
}