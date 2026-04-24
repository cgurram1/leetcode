class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m = len(obstacleGrid[0])
        n = len(obstacleGrid)
        dp = [[0]*(m+1) for _ in range(n+1)]
        if obstacleGrid[n-1][m-1] == 0:
            dp[n-1][m-1] = 1
        for i in range(n-1,-1,-1):
            for j in range(m-1,-1,-1):
                if obstacleGrid[i][j] == 1 or (i == n-1 and j == m-1):
                    continue
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        return dp[0][0]
        # def fun(i1,i2):
        #     if i1 >= n or i2 >= m or obstacleGrid[i1][i2] == 1:
        #         return 0
        #     if i1 == n-1 and i2 == m-1:
        #         return 1
        #     return fun(i1+1,i2) + fun(i1,i2+1)
        # return fun(0,0)