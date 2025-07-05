class Solution {
    public void solveSudoku(char[][] board) {
        Set<Character>[] rowMap = new HashSet[9];
        for (int i = 0; i < 9; i++) rowMap[i] = new HashSet<>();
        Set<Character>[] colMap = new HashSet[9];
        for (int i = 0; i < 9; i++) colMap[i] = new HashSet<>();
        Set<Character>[] cellMap = new HashSet[9];
        for (int i = 0; i < 9; i++) cellMap[i] = new HashSet<>();
        for(int i = 0;i<9;i++){
            rowMap[i] = new HashSet<>();
            colMap[i] = new HashSet<>();
            cellMap[i] = new HashSet<>();
        }
        int cell;
        List<int []> toBeFilled = new ArrayList<>();
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] != '.'){
                    rowMap[i].add(board[i][j]);
                    colMap[j].add(board[i][j]);
                    cell = (i/3) + 3 * (j/3);
                    cellMap[cell].add(board[i][j]);
                }
                else{
                    toBeFilled.add(new int[]{i,j});
                }
            }
        }
        fun(board,toBeFilled,0,rowMap,colMap,cellMap);
        return;
    }

    public boolean canPlace(int i, int j, int cell, char ch, Set<Character>[] rowMap,Set<Character>[] colMap, Set<Character>[] cellMap){
        if(rowMap[i].contains(ch) == true || colMap[j].contains(ch) == true || cellMap[cell].contains(ch) == true){
            return false;
        }
        return true;
    }

    public boolean fun(char[][] board,List<int []> toBeFilled, int curr,Set<Character>[] rowMap,Set<Character>[] colMap, Set<Character>[] cellMap){
        if(curr == toBeFilled.size()){
            return true;
        }
        int cell;
        char ch;
        int i = toBeFilled.get(curr)[0];
        int j = toBeFilled.get(curr)[1];
        cell = (i/3) + 3 * (j/3);
        for(int val = 1;val<10;val++){
            ch = (char)(val + '0');
            if(canPlace(i,j,cell,ch,rowMap,colMap,cellMap) == true){
                board[i][j] = ch;
                rowMap[i].add(ch);
                colMap[j].add(ch);
                cellMap[cell].add(ch);
                if(fun(board,toBeFilled,curr+1,rowMap,colMap,cellMap) == true){
                    return true;
                }
                board[i][j] = '.';
                rowMap[i].remove(ch);
                colMap[j].remove(ch);
                cellMap[cell].remove(ch);
            }
        }
        return false;
    }
}