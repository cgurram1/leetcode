class Solution {
    List<String> result = new ArrayList<>();
    int [] xs = new int[]{1,-1,0,0};
    int [] ys = new int[]{0,0,1,-1};
    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        for(String word : words){
            t.addWord(word);
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(t.arr[board[i][j] - 'a']!= null){
                    fun(i,j,new StringBuilder("" + board[i][j]), t.arr[board[i][j] - 'a'],board);
                }
            }
        }
        return result;
    }
    public void fun(int x, int y, StringBuilder currString, Trie currNode,char[][] board){
        if(currNode.noOfEnd > 0){
            result.add(currString.toString());
            currNode.noOfEnd -=1;
        }
        char original = board[x][y];
        board[x][y] = '#';  // mark visited

        for (int i = 0; i < 4; i++) {
            int nextX = x + xs[i];
            int nextY = y + ys[i];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length 
                && board[nextX][nextY] != '#'  // don't revisit
                && currNode.arr[board[nextX][nextY] - 'a'] != null) {
                
                currString.append(board[nextX][nextY]);
                fun(nextX, nextY, currString, currNode.arr[board[nextX][nextY] - 'a'], board);
                currString.setLength(currString.length() - 1);
            }
        }

        board[x][y] = original;  // unmark

    }

}

class Trie{
    public Trie [] arr;
    public int noOfEnd;
    public Trie(){
        this.arr = new Trie[26];
    }
    public void addWord(String word){
        Trie currNode = this;
        int index;
        for(int i = 0;i<word.length();i++){
            index = word.charAt(i) - 'a';
            if(currNode.arr[index] == null){
                currNode.arr[index] = new Trie();
            }
            currNode = currNode.arr[index];
        }
        currNode.noOfEnd += 1;
    }
    public void printTrie(){
        for(int i = 0;i<26;i++){
            if(arr[i] != null){
                fun(arr[i],new StringBuilder("" + (char)(i + 'a')));
            }
        }
    }
    public void fun(Trie currNode, StringBuilder str){
        if (currNode == null) return;
        if (currNode.noOfEnd > 0) {
            System.out.println(str.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (currNode.arr[i] != null) {
                str.append((char)(i + 'a'));
                fun(currNode.arr[i], str);
                str.setLength(str.length() - 1);
            }
        }
    }
}