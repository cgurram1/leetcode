class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        queue = deque()
        m = len(board[0])
        n = len(board)
        for c in range(m):
            if board[0][c] == 'O':
                queue.append((0,c))
            if board[n-1][c] == 'O':
                queue.append((n-1,c))
        for r in range(1,n-1):
            if board[r][0] == 'O':
                queue.append((r,0))
            if board[r][m-1] == 'O':
                queue.append((r,m-1))
        print(queue)
        def DFS(node):
            x,y = node[0],node[1]
            board[x][y] = -1
            for di,dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                nr,nc = x + di, y + dj
                if 0 <= nr < n and 0 <= nc < m and board[nr][nc] == 'O':
                    board[nr][nc] = -1
                    DFS((nr,nc))
        while queue:
            px,py = queue.popleft()
            if board[px][py] == 'O':
                DFS((px,py))
        for r in range(n):
            for c in range(m):
                if board[r][c] == 'O':
                    board[r][c] = 'X'
                if board[r][c] == -1:
                    board[r][c] = 'O'

