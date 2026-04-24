class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0]*(m+1) for _ in range(n+1)]
        dp[n-1][m-1] = 1
        for i in range(m+1):
            dp[n][i] = 0
        for i in range(n+1):
            dp[i][m] = 0
        for i in range(n-1,-1,-1):
            for j in range(m-1,-1,-1):
                if i == n-1 and j == m-1:
                    continue
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
        return dp[0][0]
        # def fun(i1,i2):
        #     if i1 == m-1 and i2 == n-1:
        #         return 1
        #     if i1 >= m or i2 >= n:
        #         return 0
        #     return fun(i1+1,i2) + fun(i1,i2+1)
        # return fun(0,0)