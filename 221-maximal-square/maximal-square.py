class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        dp = [[0 for _ in range(len(matrix[0])+1)] for _ in range(len(matrix)+1)]
        m = len(matrix)
        n = len(matrix[0])
        maxi = 0
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if matrix[i][j] == "1":
                    print((i+1,j+1), dp[i+1][j+1],(i+1,j), dp[i+1][j],(i,j+1),dp[i][j+1])
                    dp[i][j] = 1 + min(dp[i+1][j+1],dp[i+1][j],dp[i][j+1])
                    maxi = max(maxi,dp[i][j])
        return maxi * maxi