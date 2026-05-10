class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        visited = [[-1 for _ in range(len(grid[0]))] for _ in range(len(grid))]
        def dfs(i,j):
            visited[i][j] = 0
            ans = True
            for di,dj in dirs:
                ni,nj = i + di, j + dj
                if ni < 0 or ni >= len(grid) or nj < 0 or nj >= len(grid[0]):
                    ans = False
                elif visited[ni][nj] == -1 and grid[ni][nj] == 0:
                    ans = dfs(ni,nj) and ans
            return ans


        count = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if visited[i][j] == -1 and grid[i][j] == 0:
                    if dfs(i,j) == True:
                        count+=1
        return count