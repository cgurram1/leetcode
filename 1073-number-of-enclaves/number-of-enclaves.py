class Solution:
    def numEnclaves(self, grid: List[List[int]]) -> int:
        queue = deque()
        m = len(grid[0])
        n = len(grid)
        for c in range(m):
            if grid[0][c] == 1:
                queue.append((0,c))
            if grid[n-1][c] == 1:
                queue.append((n-1,c))
        for r in range(1,n-1):
            if grid[r][0] == 1:
                queue.append((r,0))
            if grid[r][m-1] == 1:
                queue.append((r,m-1))
        while queue:
            cr,cc = queue.popleft()
            if grid[cr][cc] == 1:
                grid[cr][cc] = 0
                for di,dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                    nr,nc = cr + di, cc + dj
                    if 0 <= nr < n and 0 <= nc < m and grid[nr][nc] == 1:
                        queue.append((nr,nc))
        count = 0
        for r in range(n):
            for c in range(m):
                if grid[r][c] == 1:
                    count+=1
        return count