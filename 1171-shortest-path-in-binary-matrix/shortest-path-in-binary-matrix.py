class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        if grid[0][0] == 1:
            return -1
        visited = [[-1]*len(grid[0]) for _ in range(len(grid))]
        queue = deque()
        queue.append((0,0,1))
        dirs = [(0,1),(0,-1),(1,0),(-1,0),(1,-1),(-1,1),(-1,-1),(1,1)]
        visited[0][0] = 1
        while queue:
            ci,cj,level = queue.popleft()
            if ci == len(grid) - 1 and cj == len(grid[0])-1:
                return level
            for di,dj in dirs:
                ni,nj = ci + di, cj + dj
                if 0 <= ni < len(grid) and 0 <= nj < len(grid[0]):
                    if visited[ni][nj] == -1 and grid[ni][nj] == 0:
                        visited[ni][nj] = 1
                        queue.append((ni,nj,level+1))
        return -1