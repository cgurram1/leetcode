class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int [] xNext = new int[]{1,-1,0,0};
        int [] yNext = new int[]{0,0,1,-1};
        int fresh = 0;
        int rotten = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j));
                    rotten +=1;
                }
                else if(grid[i][j] == 1){
                    fresh+=1;
                }
            }
        }
        int result = 0;
        queue.add(null);
        while(queue.size() > 1){
            while(queue.peek() != null){
                Pair curr = queue.poll();
                for(int i = 0;i<4;i++){
                    int nextx = curr.x + xNext[i];
                    int nexty = curr.y + yNext[i];
                    if(nextx >= 0 && nextx < grid.length && nexty >= 0 && nexty < grid[0].length && grid[nextx][nexty] == 1){
                        queue.add(new Pair(nextx,nexty));
                        grid[nextx][nexty] = 2;
                        fresh-=1;
                    }
                }
            }
            queue.poll();
            queue.add(null);
            result+=1;
        }
        if(fresh > 0){
            return -1;
        }
        if(rotten == 0){
            return 0;
        }
        return result-1;
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