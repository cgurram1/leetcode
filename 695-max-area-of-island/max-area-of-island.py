class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        visited = [[0] * n for _ in range(m)]
        x = [1,-1,0,0]
        y = [0,0,1,-1]
        def DFS(i,j,visited,temp):
            visited[i][j] = 1
            for p in range(4):
                x_next = i + x[p]
                y_next = j + y[p]
                if x_next >= 0 and x_next < m and y_next >= 0 and y_next < n and grid[x_next][y_next] == 1 and visited[x_next][y_next] == 0:
                    temp[0]+=1
                    DFS(x_next,y_next,visited,temp)
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1 and visited[i][j] == 0:
                    temp = [1]
                    DFS(i,j,visited,temp)
                    res = max(res,temp[0])
        return res
