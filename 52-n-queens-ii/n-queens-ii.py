class Solution:
    def totalNQueens(self, n: int) -> List[List[str]]:

        board = [['.'] * n for _ in range(n)]

        cols = set()
        diag1 = set()
        diag2 = set()

        def backtrack(row):
            if row == n:
                return 1
            ans = 0
            for col in range(n):

                if (col in cols or
                    (row - col) in diag1 or
                    (row + col) in diag2):
                    continue
                board[row][col] = 'Q'
                cols.add(col)
                diag1.add(row - col)
                diag2.add(row + col)

                ans+=backtrack(row + 1)
                board[row][col] = '.'
                cols.remove(col)
                diag1.remove(row - col)
                diag2.remove(row + col)
            return ans

        return backtrack(0)