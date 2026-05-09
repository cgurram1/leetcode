class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        n = len(obstacleGrid)
        m = len(obstacleGrid[0])
        if obstacleGrid[0][0] == 1 or obstacleGrid[n-1][m-1] == 1:
            return 0
        dirs = [(1,0),(0,1)]
        dp = [[-1 for _ in range(m+1)] for _ in range(n+1)]
        def fun(i,j):
            if i == n-1 and j == m-1:
                return 1
            if dp[i][j] != -1:
                return dp[i][j]
            ans = 0
            for di,dj in dirs:
                ni,nj = i + di, j + dj
                if 0 <= ni < n and 0 <= nj < m and obstacleGrid[ni][nj] != 1:
                    ans += fun(ni,nj)
            dp[i][j] = ans
            return ans
        return fun(0,0)
