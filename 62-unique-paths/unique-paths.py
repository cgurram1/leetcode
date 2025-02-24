class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[-1 for _ in range(n+1)] for _ in range(m+1)]
        def rec(r,c):
            if r == m-1 and c == n - 1:
                return 1
            elif r > m-1 or c > n-1:
                return 0
            if dp[r][c] != -1:
                return dp[r][c]
            down = rec(r+1,c)
            right = rec(r,c+1)
            dp[r][c] = down + right
            return dp[r][c]
        return rec(0,0)
