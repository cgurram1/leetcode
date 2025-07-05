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
        List<int []> toBeFilled = new ArrayList<>();
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] != '.'){
                    rowMap.get(i).add(board[i][j]);
                    colMap.get(j).add(board[i][j]);
                    cell = (i/3) + 3 * (j/3);
                    cellMap.get(cell).add(board[i][j]);
                }
                else{
                    toBeFilled.add(new int[]{i,j});
                }
            }
        }
        fun(board,toBeFilled,0,rowMap,colMap,cellMap);
        return;
    }

    public boolean canPlace(int i, int j, int cell, char ch, Map<Integer,Set<Character>> rowMap,Map<Integer,Set<Character>> colMap, Map<Integer,Set<Character>> cellMap){
        if(rowMap.get(i).contains(ch) == true || colMap.get(j).contains(ch) == true || cellMap.get(cell).contains(ch) == true){
            return false;
        }
        return true;
    }

    public boolean fun(char[][] board,List<int []> toBeFilled, int curr,Map<Integer,Set<Character>> rowMap,Map<Integer,Set<Character>> colMap, Map<Integer,Set<Character>> cellMap){
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
                rowMap.get(i).add(ch);
                colMap.get(j).add(ch);
                cellMap.get(cell).add(ch);
                if(fun(board,toBeFilled,curr+1,rowMap,colMap,cellMap) == true){
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