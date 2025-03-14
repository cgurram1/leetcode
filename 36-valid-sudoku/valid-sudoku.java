class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean [][] row = new boolean[9][9];
        boolean [][] col = new boolean[9][9];
        boolean [][] box = new boolean[9][9];
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] != '.'){
                    int digit = board[i][j] - '1';
                    int boardIndex = (i / 3) * 3 + (j / 3);
                    if(row[i][digit] || col[digit][j] || box[boardIndex][digit]){
                        return false;
                    }
                    row[i][digit] = true;
                    col[digit][j] = true;
                    box[boardIndex][digit] = true;
                }
            }
        }
        return true;
    }
} 