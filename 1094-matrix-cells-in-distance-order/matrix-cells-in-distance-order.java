class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        // List<int []> result = new ArrayList<>();
        int [][] result = new int[rows*cols][2];
        int index = 0;
        int [][] visited = new int[rows][cols];
        int [] x = new int[]{0,0,1,-1};
        int [] y = new int[]{1,-1,0,0};
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{rCenter,cCenter});
        visited[rCenter][cCenter] = 1;
        while(!queue.isEmpty()){
            int [] curr = queue.poll().clone();
            result[index] = curr;
            index = index + 1;
            for(int i = 0;i<4;i++){
                int xNext = curr[0] + x[i];
                int yNext = curr[1] + y[i];
                if(xNext >= 0 && xNext < rows && yNext >= 0 && yNext < cols && visited[xNext][yNext] == 0){
                    queue.add(new int[]{xNext,yNext});
                    visited[xNext][yNext] = 1;
                }
            }
        }
        return result;
    }
}