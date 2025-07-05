import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        fun(board, n);
        return res;
    }
    public boolean fun(char[][] board, int remaining) {
        int row = board.length - remaining;
        if (remaining == 0) {
            List<String> list = new ArrayList<>();
            for (char[] r : board) {
                list.add(new String(r));
            }
            res.add(list);
            return false;
        }
        int size = board.length;
        for (int j = 0; j < size; j++) {
            if (canPlace(board, row, j)) {
                board[row][j] = 'Q';
                fun(board, remaining - 1);
                board[row][j] = '.';
            }
        }
        return false;
    }
    public boolean canPlace(char[][] board, int x, int y) {
        int n = board.length;
        // check column and row
        for (int k = 0; k < n; k++) {
            if (board[k][y] == 'Q' || board[x][k] == 'Q') {
                return false;
            }
        }
        // check four diagonals
        int tempx, tempy;
        tempx = x; tempy = y;
        while (tempx < n && tempy < n) {
            if (board[tempx][tempy] == 'Q') return false;
            tempx++; tempy++;
        }
        tempx = x; tempy = y;
        while (tempx >= 0 && tempy >= 0) {
            if (board[tempx][tempy] == 'Q') return false;
            tempx--; tempy--;
        }
        tempx = x; tempy = y;
        while (tempx < n && tempy >= 0) {
            if (board[tempx][tempy] == 'Q') return false;
            tempx++; tempy--;
        }
        tempx = x; tempy = y;
        while (tempx >= 0 && tempy < n) {
            if (board[tempx][tempy] == 'Q') return false;
            tempx--; tempy++;
        }
        return true;
    }
}
