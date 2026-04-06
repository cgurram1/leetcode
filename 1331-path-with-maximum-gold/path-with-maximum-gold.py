"""

1,0,7
2,0,6
3,4,5
0,3,0
9,0,20


"""
class Solution:
    def getMaximumGold(self, grid):
        rows, cols = len(grid), len(grid[0])
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        def dfs(i, j):
            gold = grid[i][j]
            grid[i][j] = 0
            max_gold = 0
            for di, dj in dirs:
                ni, nj = i + di, j + dj
                if 0 <= ni < rows and 0 <= nj < cols and grid[ni][nj] > 0:
                    max_gold = max(max_gold, dfs(ni, nj))
            grid[i][j] = gold
            return gold + max_gold
        result = 0
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] > 0:
                    result = max(result, dfs(i, j))
        return result

        