class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        x = [1,-1,1,-1,0,1,-1,0]
        y = [1,-1,-1,1,1,0,0,-1]
        # 2 current alive but will be dead
        # 3 current dead but will be alive
        for i in range(len(board)):
            for j in range(len(board[0])):
                live = 0
                for p in range(8):
                    xNext = i + x[p]
                    yNext = j + y[p]
                    if xNext >= 0 and xNext < len(board) and yNext >= 0 and yNext < len(board[0]):
                        if board[xNext][yNext] in [1,2]:
                            live+=1
                if board[i][j] in [1,2]:
                    if live < 2 or live > 3:
                        board[i][j] = 2
                elif board[i][j] in [0,3]:
                    if live == 3:
                        board[i][j] = 3
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == 2:
                    board[i][j] = 0
                elif board[i][j] == 3:
                    board[i][j] = 1

                    
                    

        