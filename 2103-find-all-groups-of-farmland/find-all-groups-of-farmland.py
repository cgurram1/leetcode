class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:
        rows, cols = len(land), len(land[0])
        result = []
        dirs = ((1,0), (-1,0), (0,1), (0,-1))
        def dfs(i, j):
            nonlocal curr
            land[i][j] = 0
            curr[0] = max(curr[0], i)
            curr[1] = max(curr[1], j)

            for di, dj in dirs:
                ni, nj = i + di, j + dj
                if 0 <= ni < rows and 0 <= nj < cols and land[ni][nj] == 1:
                    dfs(ni, nj)

        for i in range(rows):
            for j in range(cols):
                if land[i][j] == 1:
                    curr = [i,j]
                    dfs(i, j)
                    result.append([i,j] + curr.copy())

        return result
