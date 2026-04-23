class Solution:
    def climbStairs(self, n: int) -> int:
        dp = [i for i in range(n+1)]
        if n <= 2:
            return dp[n]
        for i in range(3,n+1):
            dp[i] = dp[i-1] + dp[i-2]
        return dp[n]

