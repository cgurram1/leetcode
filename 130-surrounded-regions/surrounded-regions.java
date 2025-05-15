class Solution {
    int [] x = new int[]{1,-1,0,0};
    int [] y = new int[]{0,0,1,-1};
    public void solve(char[][] board) {
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if((i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) && board[i][j] == 'O'){
                    fun(i,j,board);
                }
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == 'Y'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void fun(int i, int j, char [][] board){
        board[i][j] = 'Y';
        for(int k = 0;k<4;k++){
            int nexti = i + x[k];
            int nextj = j + y[k];
            if(nexti >= 0 && nexti < board.length && nextj >= 0 && nextj < board[0].length && board[nexti][nextj] == 'O'){
                fun(nexti,nextj,board);
            }
        }
    }
}