class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        levels = 0
        visited = [[0] * len(grid[0]) for _ in range(len(grid))]
        queue = []
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 2:
                    queue.append((r,c))
        queue.append(None)
        while queue[0] != None:
            while queue[0] != None:
                ci,cj = queue.pop(0)
                for di,dj in [(1,0),(0,1),(-1,0),(0,-1)]:
                    ni,nj = di + ci, dj + cj
                    if ni >= 0 and ni < len(grid) and nj >= 0 and nj < len(grid[0]) and grid[ni][nj] == 1 and visited[ni][nj] == 0:
                        visited[ni][nj] = 1
                        queue.append((ni,nj))
                        grid[ni][nj] = 2
            queue.append(queue.pop(0))
            levels+=1
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 1:
                    return -1
        if levels <= 0:
            return 0
        return levels - 1