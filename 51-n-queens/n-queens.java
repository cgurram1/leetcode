class Solution {
    List<List<String>> resultG = new ArrayList<>();
    boolean [] colCheck;
    int N;
    public List<List<String>> solveNQueens(int n) {
        List<String> curr = new ArrayList<>();
        colCheck = new boolean[n];
        N = n;
        for (int i = 0; i < n; i++) {
            curr.add(".".repeat(n));
        }
        fun(0,curr);
        return resultG;
    }
    public void fun(int queens, List<String> curr){
        if(queens == N){
            resultG.add(new ArrayList<>(curr));
            return;
        }
        for(int j = 0;j<N;j++){
            if (!colCheck[j] && diagCheck(queens, j, curr)) {
                colCheck[j] = true;
                char[] row = curr.get(queens).toCharArray();
                row[j] = 'Q';
                curr.set(queens, new String(row));
                fun(queens + 1, curr);
                row[j] = '.';
                curr.set(queens, new String(row));
                colCheck[j] = false;
            }
        }
    }
    public boolean diagCheck(int r, int c, List<String> curr) {
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (curr.get(i).charAt(j) == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < N; i--, j++) {
            if (curr.get(i).charAt(j) == 'Q') return false;
        }
        return true;
    }
}