class Solution {
    public int[][] generateMatrix(int n) {
        int [][] mat = new int[n][n];
        sol(0,0,mat,0,1,n);
        return mat;
    }
    public void sol(int x,int y,int [][] mat,int iter,int val,int n){
        if(x == n/2){
            if(mat[x][y]== 0){
                mat[x][y] = val;
            }
            return;
        }
        int i = x;
        int j;
        //right:
        for(j = y;j<n-iter;j++){
            mat[x][j] = val;
            val++;
        }
        //down
        j = j-1;
        for(i = i+1;i<n-iter;i++){
            mat[i][j] = val;
            val++;
        }
        i--;
        //left
        for(j = j-1;j>=iter;j--){
            mat[i][j] = val;
            val++;
        }
        j++;
        //up
        for(i = i-1;i>iter;i--){
            mat[i][j] = val;
            val++;
        }
        sol(x+1,y+1,mat,iter + 1,val,n);
    }
}