class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        dp = [[0]*(m+1) for _ in range(n+1)]
        dp[n-1][m-1] = grid[n-1][m-1]
        for i in range(n+1):
            dp[i][m] = float('inf')
        for i in range(m+1):
            dp[n][i] = float('inf')
        for i in range(n-1,-1,-1):
            for j in range(m-1,-1,-1):
                if i == n-1 and j == m-1:
                    continue
                dp[i][j] = grid[i][j] + min(dp[i+1][j],dp[i][j+1])
        return dp[0][0]
        # def fun(i1,i2):
        #     if i1 == n-1 and i2 == m-1:
        #         return grid[i1][i2]
        #     if i1 >= n or i2 >= m:
        #         return float('inf')
        #     return grid[i1][i2] + min(fun(i1+1,i2),fun(i1,i2+1))
        # return fun(0,0)
