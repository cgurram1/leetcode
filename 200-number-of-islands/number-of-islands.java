class Solution {
    public int numIslands(char[][] grid) {
        int [] X = new int[]{1,-1,0,0};
        int [] Y = new int[]{0,0,1,-1};
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        Queue<Pair> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    queue.add(new Pair(i,j));
                    bfs(grid,visited,queue,X,Y);
                    count+=1;
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid,boolean [][] visited, Queue<Pair> queue, int [] X, int [] Y){
        while(queue.isEmpty() == false){
            Pair popped = queue.poll();
            int x = popped.x;
            int y = popped.y;
            for(int i = 0;i<4;i++){
                int nextx = x + X[i];
                int nexty = y + Y[i];
                if(nextx >= 0 && nextx < grid.length && nexty >= 0 && nexty < grid[0].length && visited[nextx][nexty] == false && grid[nextx][nexty] == '1'){
                    queue.add(new Pair(nextx,nexty));
                    visited[nextx][nexty] = true;
                }
            }
        }
    }
}
class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }   
}