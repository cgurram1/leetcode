from heapq import heappush, heappop

class Solution:
    def minimumTime(self, grid):
        m, n = len(grid), len(grid[0])
        
        if grid[1][0] > 1 and grid[0][1] > 1:
            return -1
        
        dist = [[float('inf')] * n for _ in range(m)]
        dist[0][0] = 0
        
        heap = [(0, 0, 0)]
        dirs = [(1,0),(-1,0),(0,1),(0,-1)]
        
        while heap:
            time, i, j = heappop(heap)
            if (i, j) == (m-1, n-1):
                return time
            if time > dist[i][j]:
                continue
            for di, dj in dirs:
                ni, nj = i + di, j + dj
                if 0 <= ni < m and 0 <= nj < n:
                    next_time = time + 1
                    if next_time < grid[ni][nj]:
                        next_time = grid[ni][nj]
                        if (next_time - time) % 2 == 0:
                            next_time += 1
                    if next_time < dist[ni][nj]:
                        dist[ni][nj] = next_time
                        heappush(heap, (next_time, ni, nj))
        return -1