class Solution {
    int [] x = new int[]{1,-1,0,0};
    int [] y = new int[]{0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        int [][] visited = new int[board.length][board[0].length];
        for(int [] arr : visited){
            Arrays.fill(arr,-1);
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(fun(i,j,word,board,visited,1) == true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean fun(int i,int j,String word,char [][] board,int [][] visited,int index){
        visited[i][j] = 1;
        if(index > word.length()){
            visited[i][j] = -1;
            return false;
        }
        if(index == word.length()){
            return true;
        }
        for(int k = 0;k<4;k++){
            int nexti = i + x[k];
            int nextj = j + y[k];
            if(nexti >= 0 && nexti < board.length && nextj >= 0 && nextj < board[0].length && visited[nexti][nextj] == -1 && board[nexti][nextj] == word.charAt(index)){
                if(fun(nexti,nextj,word,board,visited,index + 1)){
                    return true;
                }
            }
        }
        visited[i][j] = -1;
        return false;
    }
}