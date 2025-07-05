class Solution {
    public void solveSudoku(char[][] board) {
        Map<Integer,Set<Character>> rowMap = new HashMap<>();
        Map<Integer,Set<Character>> colMap = new HashMap<>();
        Map<Integer,Set<Character>> cellMap = new HashMap<>();
        for(int i = 0;i<9;i++){
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            cellMap.put(i, new HashSet<>());
        }
        int cell;
        int remaining = 81;
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] != '.'){
                    rowMap.get(i).add(board[i][j]);
                    colMap.get(j).add(board[i][j]);
                    cell = (i/3) + 3 * (j/3);
                    cellMap.get(cell).add(board[i][j]);
                    remaining-=1;
                }
            }
        }
        fun(board,remaining,rowMap,colMap,cellMap);
        return;
    }

    public boolean canPlace(int i, int j, int cell, char ch, Map<Integer,Set<Character>> rowMap,Map<Integer,Set<Character>> colMap, Map<Integer,Set<Character>> cellMap){
        if(rowMap.get(i).contains(ch) == true || colMap.get(j).contains(ch) == true || cellMap.get(cell).contains(ch) == true){
            return false;
        }
        return true;
    }

    public boolean fun(char[][] board, int remaining,Map<Integer,Set<Character>> rowMap,Map<Integer,Set<Character>> colMap, Map<Integer,Set<Character>> cellMap){
        if(remaining == 0){
            return true;
        }
        int cell;
        char ch;
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] == '.'){
                    cell = (i/3) + 3 * (j/3);
                    for(int val = 1;val<10;val++){
                        ch = (char)(val + '0');
                        if(canPlace(i,j,cell,ch,rowMap,colMap,cellMap) == true){
                            board[i][j] = ch;
                            rowMap.get(i).add(ch);
                            colMap.get(j).add(ch);
                            cellMap.get(cell).add(ch);
                            if(fun(board,remaining-1,rowMap,colMap,cellMap) == true){
                                return true;
                            }
                            board[i][j] = '.';
                            rowMap.get(i).remove(ch);
                            colMap.get(j).remove(ch);
                            cellMap.get(cell).remove(ch);
                        }
                    }
                return false;
                }
            }
        }
        return false;
    }
}