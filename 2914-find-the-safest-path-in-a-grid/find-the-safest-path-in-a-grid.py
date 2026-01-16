class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        dists = [[float('inf')] * len(grid[0]) for _ in range(len(grid))]
        visited = [[-1] * len(grid[0]) for _ in range(len(grid))]
        ones = deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(grid[i][j] == 1):
                    ones.append((i,j))
                    dists[i][j] = 0
        ones.append(None)
        dist = 0
        while(ones[0] != None):
            dist += 1
            while(ones[0] != None):
                i,j = ones.popleft()
                for nextC in [(1,0),(-1,0),(0,-1),(0,1)]:
                    ni,nj = i + nextC[0], j + nextC[1]
                    if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]):
                        if dists[ni][nj] == float('inf'):
                            dists[ni][nj] = dist
                            ones.append((ni,nj))
            ones.append(ones.popleft())
        
        n = len(grid)
        pq = [(-dists[0][0], 0, 0)]  # max heap via negative
        seen = [[False]*n for _ in range(n)]

        while pq:
            safe, i, j = heapq.heappop(pq)
            safe = -safe

            if (i, j) == (n-1, n-1):
                return safe

            if seen[i][j]:
                continue
            seen[i][j] = True

            for di, dj in [(1,0),(-1,0),(0,1),(0,-1)]:
                ni, nj = i+di, j+dj
                if 0 <= ni < n and 0 <= nj < n and not seen[ni][nj]:
                    heapq.heappush(
                        pq,
                        (-min(safe, dists[ni][nj]), ni, nj)
                    )
        return 0