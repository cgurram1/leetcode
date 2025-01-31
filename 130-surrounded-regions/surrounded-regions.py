class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        visited = [[0 for _ in range(len(board[0]))] for _ in range(len(board))]
        x = [1,-1,0,0]
        y = [0,0,-1,1]
        def DFS(i,j):
            visited[i][j] = 1
            board[i][j] = "T"
            for k in range(4):
                nexti = i + x[k]
                nextj = j + y[k]
                if nexti >= 0 and nexti < len(board) and nextj >= 0 and nextj < len(board[0]) and visited[nexti][nextj] == 0 and board[nexti][nextj] == "O":
                    DFS(nexti,nextj)
        
        for i in range(len(board)):
            if board[i][0] == "O":
                DFS(i, 0)
            if board[i][-1] == "O":
                DFS(i, len(board[0]) - 1)

        for j in range(len(board[0])):
            if board[0][j] == "O":
                DFS(0, j)
            if board[-1][j] == "O":
                DFS(len(board) - 1, j)
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == "O":
                    board[i][j] = "X"
                elif board[i][j] == "T":
                    board[i][j] = "O"

