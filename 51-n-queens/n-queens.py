class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [['.']*n for _ in range(n)]
        def canPlace(board,row,col):
            for r in range(row):
                if board[r][col] == 'Q':
                    return False
            r,c = row,col
            r-=1
            c-=1
            while r >= 0 and c >= 0:
                if board[r][c] == 'Q':
                    return False
                r-=1
                c-=1
            r,c = row,col
            r-=1
            c+=1
            while r >= 0 and c < n:
                if board[r][c] == 'Q':
                    return False
                r-=1
                c+=1
            return True

        result = []
        def placeQueen(board,remaining,n,row):
            if remaining == 0:
                return True
            for col in range(n):
                if canPlace(board, row,col):
                    board[row][col] = 'Q'
                    if placeQueen(board,remaining - 1,n,row+1):
                        temp = []
                        for r in board:
                            temp.append(''.join(r))
                        result.append(temp)
                    board[row][col] = '.'
        board = placeQueen(board,n,n,0)
        return result