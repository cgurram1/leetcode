class Solution {
    public int count = 0;
    public int totalNQueens(int n) {
        int [][] board = new int[n][n];
        fun(board,0);
        return count;
    }
    public void fun(int [][] board,int row){
        if(row == board.length){
            count+=1;
            return;
        }
        for(int col = 0;col < board.length;col++){
            if(canPlace(board,row,col) == true){
                board[row][col] = 1;
                fun(board,row+1);
                board[row][col] = 0;
            }
        }
    }
    public boolean canPlace(int [][] board,int row, int col){
        int n = board.length;
        for(int k = 0;k<board.length;k++){
            if(board[row][k] == 1 || board[k][col] == 1){
                return false;
            }
        }
        int tempx = row;
        int tempy = col;
        while(tempx < n && tempy < n){
            if(board[tempx][tempy] == 1){
                return false;
            }
            tempx++;
            tempy++;
        }
        tempx = row;
        tempy = col;
        while(tempx >= 0 && tempy >= 0){
            if(board[tempx][tempy] == 1){
                return false;
            }
            tempx--;
            tempy--;
        }
        tempx = row;
        tempy = col;
        while(tempx < n && tempy >= 0){
            if(board[tempx][tempy] == 1){
                return false;
            }
            tempx++;
            tempy--;
        }
        tempx = row;
        tempy = col;
        while(tempx >= 0 && tempy < n){
            if(board[tempx][tempy] == 1){
                return false;
            }
            tempx--;
            tempy++;
        }
        return true;
    }
}