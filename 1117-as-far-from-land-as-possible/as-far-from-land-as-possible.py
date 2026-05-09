class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        dists = [[-1 for _ in range(len(grid[0]))] for _ in range(len(grid))]
        queue = deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    queue.append((i,j))
                    dists[i][j] = 0
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        dist = 0
        result = 0
        while queue:
            dist+=1
            for _ in range(len(queue)):
                ci,cj = queue.popleft()
                for di,dj in dirs:
                    ni,nj = ci + di, cj + dj
                    if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]) and grid[ni][nj] == 0 and dists[ni][nj] == -1:
                        dists[ni][nj] = dist
                        result = max(result,dist)
                        queue.append((ni,nj))
        if result == 0:
            return -1
        return result
            