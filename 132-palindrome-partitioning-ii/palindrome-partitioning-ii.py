class Solution:
    def minCut(self, s: str) -> int:
        n = len(s)
        palindromeChecker = [[False] * n for _ in range(n)]
        for i in range(n):
            palindromeChecker[i][i] = True
        for i in range(n-1):
            if s[i] == s[i+1]:
                palindromeChecker[i][i+1] = True
        for i in range(n-1, -1, -1):
            for j in range(i, n):
                if not palindromeChecker[i][j]:
                    palindromeChecker[i][j] = s[i] == s[j] and palindromeChecker[i+1][j-1]
        dp = [float('inf') for _ in range(n+1)]
        dp[n] = 0
        for index in range(n-1,-1,-1):
            for i in range(index,n):
                if palindromeChecker[index][i]:
                    dp[index] = min(dp[index],1 + dp[i+1])
        return dp[0] - 1

        # def fun(index):
        #     if index == n:
        #         return 0
        #     val = float('inf')
        #     for i in range(index,n):
        #         if palindromeChecker[index][i]:
        #             val = min(val, fun(i+1))
        #     return 1 + val

        # return fun(0)-1
