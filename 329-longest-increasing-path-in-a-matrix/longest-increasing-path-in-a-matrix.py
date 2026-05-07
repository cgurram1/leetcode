class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        dp = [[-1] * len(matrix[0]) for _ in range(len(matrix))]
        dirs = [(1,0),(0,1),(-1,0),(0,-1)]
        def dfs(row,col):
            if dp[row][col] != -1:
                return dp[row][col]
            ans = 1
            for di,dj in dirs:
                ni,nj = row + di, col + dj
                if 0 <= ni < len(matrix) and 0 <= nj < len(matrix[0]) and matrix[ni][nj] > matrix[row][col]:
                    ans = max(ans,1 + dfs(ni,nj))
            dp[row][col] = ans
            return ans
        result = 0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                result = max(result,dfs(i,j))
        return result
