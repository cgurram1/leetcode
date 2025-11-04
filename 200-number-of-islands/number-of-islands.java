class Solution {
    public boolean visited [][];
    public char gridG[][];
    public int [] X = new int[]{1,-1,0,0};
    public int [] Y = new int[]{0,0,1,-1};
    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        gridG = grid;
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    count+=1;
                    dfs(i,j);
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j){
        visited[i][j] = true;
        for(int k = 0;k<4;k++){
            int nexti = i + X[k];
            int nextj = j + Y[k];
            if(nexti < gridG.length && nextj < gridG[0].length && nexti >= 0 && nextj >= 0){
                if(gridG[nexti][nextj] == '1' && visited[nexti][nextj] == false){
                    dfs(nexti,nextj);
                }
            }
        }
    }
}