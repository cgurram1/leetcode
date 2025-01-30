class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count = 0
        x = [1,-1,0,0]
        y = [0,0,1,-1]
        def dfs(i,j):
            grid[i][j] = "0"
            for k in range(4):
                nexti = i + x[k]
                nextj = j + y[k]
                if nexti >= 0 and nexti < len(grid) and nextj >= 0 and nextj < len(grid[0]) and grid[nexti][nextj] == "1":
                    dfs(nexti,nextj)
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == "1":
                    count+=1
                    dfs(i,j)
        return count
        
        
        
        

