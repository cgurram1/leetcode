class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        def BFS(i, j):
            island1.add((i, j))
            dirs = [(1,0),(0,1),(-1,0),(0,-1)]
            queue = deque()
            queue.append((i, j))
            while queue:
                ci, cj = queue.popleft()
                for di, dj in dirs:
                    ni, nj = ci + di, cj + dj
                    if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]) \
                        and grid[ni][nj] == 1 and (ni, nj) not in island1:
                        
                        island1.add((ni, nj))
                        queue.append((ni, nj))
        def bridge(i, j):
            queue = deque([(0, i, j) for (i, j) in island1])
            dirs = [(1,0),(0,1),(-1,0),(0,-1)]
            while queue:
                level, ci, cj = queue.popleft()
                
                for di, dj in dirs:
                    ni, nj = ci + di, cj + dj
                    
                    if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]) \
                        and (ni, nj) not in island1:
                        island1.add((ni, nj))
                        if grid[ni][nj] == 0:
                            queue.append((level + 1, ni, nj))
                        elif grid[ni][nj] == 1:
                            return level
            return 0
        island1 = set()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    BFS(i, j)
                    return bridge(i, j)
        return 0